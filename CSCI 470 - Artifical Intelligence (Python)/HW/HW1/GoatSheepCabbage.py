# Need to define what a state looks like. I'm going to make the state a tuple that has both sides of the river represented
start_state = (("F", "C", "G", "W"), ())


# Just a quick helper function for printing
def state_to_string(s):
    return "".join(s[0]) + "||" + "".join(s[1])


state_to_string(start_state)


# action(s) = possible actions
def remove_actions(letter, possible_actions, s, farmer_inx):
    if letter not in s[farmer_inx]:
        new_possible_actions = []
        for action in possible_actions:
            if letter not in action:
                new_possible_actions.append(action)
    else:  # Nothing to do
        new_possible_actions = possible_actions
    return new_possible_actions


def action(s):
    # Find out which side the farmer is on
    farmer_inx = 0
    if 'F' in s[1]:
        farmer_inx = 1
    possible_actions = ["F>", "FC>", "FG>", "FW>", "F<", "FC<", "FG<",
                        "FW<"]  # Same actions as above just a different order
    if farmer_inx == 0:
        possible_actions = possible_actions[0:4]
    else:
        possible_actions = possible_actions[4:8]

    possible_actions = remove_actions('C', possible_actions, s, farmer_inx)
    possible_actions = remove_actions('G', possible_actions, s, farmer_inx)
    possible_actions = remove_actions('W', possible_actions, s, farmer_inx)

    return possible_actions


action((('C', 'W'), ('F', 'G'))



# succ(s,a) = apply action a while in state s, returns the new state
# we are going to assume only valid actions are requested


def succ(s, a):
    new_s = (list(s[0]), list(s[1]))
    # print(new_s)
    if '<' in a:
        # moving farmer from right to left
        new_s[1].remove("F")
        new_s[0].append("F")
        if len(a) == 3:
            new_s[1].remove(str(a[1]))
            new_s[0].append(str(a[1]))
    else:
        new_s[0].remove("F")
        new_s[1].append("F")
        if len(a) == 3:
            new_s[0].remove(str(a[1]))
            new_s[1].append(str(a[1]))
    # print(new_s)
    return (tuple(new_s[0]), tuple(new_s[1]))


succ((('C', 'W'), ('F', 'G')), "F<")



# now code whether we are at the end
def isEnd(s):
    if len(s[0]) == 0:
        return True
    else:
        return False


isEnd((("W", "F"), ("C", "G")))
isEnd(((), ("W", "F", "C", "G")))


# cost(s,a) = cost of action a in state s
def cost(current_s, a):
    s = succ(current_s, a)
    max_cost = 1000

    # Find out which side the farmer is on
    non_farmer_inx = 1
    if 'F' in s[1]:
        non_farmer_inx = 0

    # Need to check and see if goat and cabbage are there without farmer
    if "C" in s[non_farmer_inx] and "G" in s[non_farmer_inx]:
        return max_cost

    # now check wolf and goat
    if "W" in s[non_farmer_inx] and "G" in s[non_farmer_inx]:
        return max_cost

    return 1


cost((("C", "F", "G"), ("W")), "F>")



"""Finish the Code Below Your task is to
implement a breadth first search solution to the Goat, Sheep, Wolf Problem
using the funtions above. Here is the function header and an example correct run."""


# Now we are ready to implement a tree search


def bfs(start):
    bfs(start_state)

