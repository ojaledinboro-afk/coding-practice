import random

WINNING_SCORE = 50

def roll():
    return random.randint(1, 6)


def get_number_of_players():
    while True:
        players = input("Enter number of players: ")
        if players.isdigit() and int(players) > 0:
            return int(players)
        print("Please enter a valid number greater than 0.")

def play_turn(player_num, total_score):
    turn_score = 0

    print(f"\n--- Player {player_num}'s turn ---")
    print(f"Current total score: {total_score}")

    while True:
        choice = input("Roll or hold? (Y = roll / N = hold): ").upper()

        if choice == "Y":
            value = roll()
            print(f"You rolled: {value}")

            if value == 1:
                print("You rolled a 1! Turn over, no points earned.")
                return 0 # Turn ends with 0 points
        
            turn_score += value
            print(f"Turn score: {turn_score} | Potential total: {total_score + turn_score}")

        elif choice == "N":
            print(f"You banked {turn_score} points")
            return turn_score # Player banks their score
        
        else: 
            print("Please type Y or N.")

def main():
    print("Welcome to the Pig Dice Game!\n")

    players = get_number_of_players()
    scores = [0] * players
    current_player = 0

    while True: 
        turn_score = play_turn(current_player + 1, scores[current_player])
        scores[current_player] += turn_score

        print(f"Player {current_player + 1}  total score: {scores[current_player]}")

        # Check for winner
        if scores[current_player] >= WINNING_SCORE:
            print(f"Player {current_player + 1} wins with {scores[current_player]} points!")
            break

        # Next player (loops back to 0)
        current_player = (current_player + 1) % players

    # Final Scoreboard
    print("\n Final Scores:")
    for i, score in enumerate(scores):
        print(f"Player {i + i}: {score}")



# Run the game
main()

