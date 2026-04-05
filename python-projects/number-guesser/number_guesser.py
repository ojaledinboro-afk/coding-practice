import random 
import os


HIGHSCORE_FILE = "highscore.txt"

def load_highscore():
    # Load the highscore from the file. Returns None if no highscore exists
    if os.path.exists(HIGHSCORE_FILE):
        with open(HIGHSCORE_FILE, "r") as file:
            try:
                return int(file.read())
            except ValueError:
                return None
        return None
    
def save_highscore(score):
    # Save the highscore to a file.
    with open(HIGHSCORE_FILE, "w") as file:
        file.write(str(score))

def guessing_game():
    print("Welcome to the Number Guessing Game!")
    highscore = load_highscore() # Load previous high score

    if highscore is not None:
        print(f"Current Highscore: {highscore} guesses")

    while True: # Outer loop for multiple rounds
        # Get the upper limit from the user
        while True:
            try:
                top_of_range =int(input("Type a number greater than 0: "))
                if top_of_range <= 0:
                    print("Please try a number larger than 0.")
                    continue
                break
            except ValueError:
                print("That's not a valid number try again.")

        # Generate random number
        random_number = random.randint(0, top_of_range)
        guesses = 0

        # Inner loop for guessing
        while True:
            guesses += 1
            user_input = input(f"Guess a number between 1 and {top_of_range} (or 'q' to quit) ").lower()

            if user_input == 'q':
                print(f"Game exited. The number was {random_number}")
                break

            try:
                user_guess = int(user_input)
            except ValueError:
                print("Please type a valid number.")
                continue

            if user_guess < 1 or user_guess > top_of_range:
                print(f"Your guess is out of range! It must be between 1 and {top_of_range}.")
                continue
            
            if user_guess == random_number:
                print(f"Congratulations! You got in {guesses} guesses. The number was {random_number}")

                # Update highscore
                if highscore is None or guesses < highscore:
                    highscore = guesses
                    save_highscore(highscore)
                    print(f"New Highscore: {highscore} guesses!")
                else:
                    print(f"Your best score so far is {highscore} guesses.")

                break
            elif user_guess > random_number:
                print("Too high! Try again.")
            else:
                print("Too low! Try again.")

        # Ask to play again
        play_again = input("Do you want to play again? (y/n) ").lower()
        if play_again != 'y':
            print(f"ThanKs for playing! Your best score was {highscore} guesses")
            break

# Start the game
guessing_game()