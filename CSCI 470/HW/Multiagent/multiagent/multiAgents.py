# multiAgents.py
# --------------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
# 
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).


from util import manhattanDistance
from game import Directions
import random, util

from game import Agent


class ReflexAgent(Agent):
    """
      A reflex agent chooses an action at each choice point by examining
      its alternatives via a state evaluation function.

      The code below is provided as a guide.  You are welcome to change
      it in any way you see fit, so long as you don't touch our method
      headers.
    """

    def getAction(self, gameState):
        """
        You do not need to change this method, but you're welcome to.

        getAction chooses among the best options according to the evaluation function.

        Just like in the previous project, getAction takes a GameState and returns
        some Directions.X for some X in the set {North, South, West, East, Stop}
        """
        # Collect legal moves and successor states
        legalMoves = gameState.getLegalActions()

        # Choose one of the best actions
        scores = [self.evaluationFunction(gameState, action) for action in legalMoves]
        bestScore = max(scores)
        bestIndices = [index for index in range(len(scores)) if scores[index] == bestScore]
        chosenIndex = random.choice(bestIndices)  # Pick randomly among the best

        "Add more of your code here if you want to"

        return legalMoves[chosenIndex]

    def evaluationFunction(self, currentGameState, action):
        """
        Design a better evaluation function here.

        The evaluation function takes in the current and proposed successor
        GameStates (pacman.py) and returns a number, where higher numbers are better.

        The code below extracts some useful information from the state, like the
        remaining food (newFood) and Pacman position after moving (newPos).
        newScaredTimes holds the number of moves that each ghost will remain
        scared because of Pacman having eaten a power pellet.

        Print out these variables to see what you're getting, then combine them
        to create a masterful evaluation function.
        """
        # Useful information you can extract from a GameState (pacman.py)

        successorGameState = currentGameState.generatePacmanSuccessor(action)
        newPos = successorGameState.getPacmanPosition()
        newFood = successorGameState.getFood()
        newGhostStates = successorGameState.getGhostStates()
        newScaredTimes = [ghostState.scaredTimer for ghostState in newGhostStates]

        "*** YOUR CODE HERE ***"
        # print successorGameState
        # print newPos
        # print newPos
        # print newGhostStates
        # print newScaredTimes
        oldFood = currentGameState.getFood()
        # currentPos = list(successorGameState.getPacmanPosition())
        # maxDistance = float('-inf')

        # Evaluation score
        score = successorGameState.getScore()

        # Remaining food
        remainingFood = newFood.asList()

        # Distance to ghost
        # ghostPositions = [Ghost.getPosition() for Ghost in newGhostStates]
        ghostDistance = manhattanDistance(newPos, newGhostStates[0].getPosition())

        # move when stopped
        if action == 'Stop':
            return float('-inf')

        # run toward ghost
        # if len(newScaredTimes)>0:
        #     score += 10/distanceToGhost

        # #Run away from ghost
        if ghostDistance <= 1:
            # print "Dist to ghost"
            # print distanceToGhost
            # score = -9999
            score = float('-inf')
        else:
            return score

        # Distance to food
        # for food in remainingFood:
        #     foodDistance = -1*manhattanDistance(newPos,food)
        foodDistance = -1 * [manhattanDistance(newPos, food) for food in remainingFood]

        # Run towards nearest food
        if foodDistance >= 1:
            # score = 9999
            score = float('-inf')

        return score


def scoreEvaluationFunction(currentGameState):
    """
      This default evaluation function just returns the score of the state.
      The score is the same one displayed in the Pacman GUI.

      This evaluation function is meant for use with adversarial search agents
      (not reflex agents).
    """
    return currentGameState.getScore()


class MultiAgentSearchAgent(Agent):
    """
      This class provides some common elements to all of your
      multi-agent searchers.  Any methods defined here will be available
      to the MinimaxPacmanAgent, AlphaBetaPacmanAgent & ExpectimaxPacmanAgent.

      You *do not* need to make any changes here, but you can if you want to
      add functionality to all your adversarial search agents.  Please do not
      remove anything, however.

      Note: this is an abstract class: one that should not be instantiated.  It's
      only partially specified, and designed to be extended.  Agent (game.py)
      is another abstract class.
    """

    def __init__(self, evalFn='scoreEvaluationFunction', depth='2'):
        self.index = 0  # Pacman is always agent index 0
        self.evaluationFunction = util.lookup(evalFn, globals())
        self.depth = int(depth)


class MinimaxAgent(MultiAgentSearchAgent):
    """
      Your minimax agent (question 2)
    """

    def getAction(self, gameState):
        """
          Returns the minimax action from the current gameState using self.depth
          and self.evaluationFunction.

          Here are some method calls that might be useful when implementing minimax.

          gameState.getLegalActions(agentIndex):
            Returns a list of legal actions for an agent
            agentIndex=0 means Pacman, ghosts are >= 1

          gameState.generateSuccessor(agentIndex, action):
            Returns the successor game state after an agent takes an action

          gameState.getNumAgents():
            Returns the total number of agents in the game
        """
        "*** YOUR CODE HERE ***"

        def minimax(gameState, depth, index):
            # check agent index
            if index >= gameState.getNumAgents():
                index = 0
                depth += 1

            # Check if state is terminal
            if (depth == self.depth or gameState.isWin() or gameState.isLose()):
                return self.evaluationFunction(gameState)
            # Pacman value
            elif (index == 0):
                return maxValue(gameState, depth, index)
            # Ghost value
            else:
                return minValue(gameState, depth, index)

        def maxValue(gameState, depth, index):
            # Initialize move and max value
            val = ["", float("-inf")]

            # Generate all possible moves for pacman
            legalMoves = gameState.getLegalActions(index)

            for move in legalMoves:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = minimax(succState, depth, index + 1)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue
                if tempVal > val[1]:
                    val = [move, tempVal]
            return val

        def minValue(gameState, depth, index):
            # Initialize move and min value
            val = ["", float("inf")]

            # Generate all possible moves for ghosts
            legalActions = gameState.getLegalActions(index)

            for move in legalActions:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = minimax(succState, depth, index + 1)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue
                if tempVal < val[1]:
                    val = [move, tempVal]
            return val

        retVal = minimax(gameState, 0, 0)
        return retVal[0]


class AlphaBetaAgent(MultiAgentSearchAgent):
    """
      Your minimax agent with alpha-beta pruning (question 3)
    """

    def getAction(self, gameState):
        """
          Returns the minimax action using self.depth and self.evaluationFunction
        """
        "*** YOUR CODE HERE ***"

        def alphaBeta(gameState, depth, index, alpha, beta):
            # check agent index
            if index >= gameState.getNumAgents():
                index = 0
                depth += 1

            # Check if state is terminal
            if (depth == self.depth or gameState.isWin() or gameState.isLose()):
                return self.evaluationFunction(gameState)
            # Pacman value
            elif (index == 0):
                return maxValue(gameState, depth, index, alpha, beta)
            # Ghost value
            else:
                return minValue(gameState, depth, index, alpha, beta)

        def maxValue(gameState, depth, index, alpha, beta):
            # Initialize move and max value
            val = ["", float("-inf")]

            # Generate all possible moves for pacman
            legalMoves = gameState.getLegalActions(index)

            for move in legalMoves:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = alphaBeta(succState, depth, index + 1, alpha, beta)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue
                if tempVal > val[1]:
                    val = [move, tempVal]
                if tempVal > beta:
                    return [move, tempVal]
                alpha = max(alpha, tempVal)
            return val

        def minValue(gameState, depth, index, alpha, beta):
            # Initialize move and min value
            val = ["", float("inf")]

            # Generate all possible moves for ghosts
            legalActions = gameState.getLegalActions(index)

            for move in legalActions:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = alphaBeta(succState, depth, index + 1, alpha, beta)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue

                if tempVal < val[1]:
                    val = [move, tempVal]
                if tempVal < alpha:
                    return [move, tempVal]
                beta = min(beta, tempVal)

            return val

        retVal = alphaBeta(gameState, 0, 0, float("-inf"), float("inf"))
        return retVal[0]


class ExpectimaxAgent(MultiAgentSearchAgent):
    """
      Your expectimax agent (question 4)
    """

    def getAction(self, gameState):
        """
          Returns the expectimax action using self.depth and self.evaluationFunction

          All ghosts should be modeled as choosing uniformly at random from their
          legal moves.
        """
        "*** YOUR CODE HERE ***"

        def expectiMax(gameState, depth, index):
            if index >= gameState.getNumAgents():
                index = 0
                depth += 1
            # Check if state is terminal
            if (depth == self.depth or gameState.isWin() or gameState.isLose()):
                return self.evaluationFunction(gameState)
            elif (index == 0):
                return maxValue(gameState, depth, index)
            else:
                return expectedValue(gameState, depth, index)

        def maxValue(gameState, depth, index):
            # Initialize move and max value
            val = ["", float("-inf")]

            # Generate all possible moves for pacman
            legalMoves = gameState.getLegalActions(index)

            for move in legalMoves:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = expectiMax(succState, depth, index + 1)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue
                if tempVal > val[1]:
                    val = [move, tempVal]
            return val

        def expectedValue(gameState, depth, index):
            # Initialize move and expected value
            val = ["", 0]

            # Generate all possible moves for ghosts
            legalMoves = gameState.getLegalActions(index)

            for move in legalMoves:
                # generate successor
                succState = gameState.generateSuccessor(index, move)
                # value of successor
                succValue = expectiMax(succState, depth, index + 1)
                if type(succValue) is list:
                    tempVal = succValue[1]
                else:
                    tempVal = succValue
                
                #Probability of successor
                expected = 1.0 / len(legalMoves)
                val[1] +=  expected * tempVal
            return val

        outputList = expectiMax(gameState, 0, 0)
        return outputList[0]

        #util.raiseNotDefined()


def betterEvaluationFunction(currentGameState):
    """
      Your extreme ghost-hunting, pellet-nabbing, food-gobbling, unstoppable
      evaluation function (question 5).

      DESCRIPTION: <write something here so we know what you did>
    """
    "*** YOUR CODE HERE ***"


#    util.raiseNotDefined()

# Abbreviation
better = betterEvaluationFunction
