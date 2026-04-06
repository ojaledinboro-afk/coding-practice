def get_choice(prompt, options):
    """Ask the player for input until they provide a valid choice."""
    choice = input(prompt).lower()
    while choice not in options:
        print("That's not a valid option. Try again.")
        choice = input(prompt).lower()
    return choice

def play_adventure(story, start_node="start"):
    current_node = start_node
    while True:
        node = story[current_node]
        print("\n" + node["description"])

        if "choices" not in node:
            # No choices means the game ends
            print("\nGame Over!\n")
            break

        choice = get_choice(" / ".join(node["choices"].keys()) + ": ", node["choices"].keys())
        current_node = node["choices"][choice]

# Post-apocalypse story
apocalypse_story = {
    "start": {
        "description": "The city is in ruins. You are a kid trying to survive. You see two paths: a crumbling street to the left, or a dark alley to the right.",
        "choices": {"left": "street", "right": "alley"}
    },
    "street": {
        "description": "You walk down the crumbling street and find a burned-out grocery store. Do you search inside or keep walking?",
        "choices": {"search": "grocery", "walk": "walk_street_end"}
    },
    "grocery": {
        "description": "Inside the store, you find some canned food but trigger a trap! You lose.",
    },
    "walk_street_end": {
        "description": "You keep walking but are caught by raiders. You lose.",
    },
    "alley": {
        "description": "The alley is dark and smells bad. You hear noises. Do you hide behind a dumpster or keep moving forward?",
        "choices": {"hide": "hide_end", "forward": "forward_end"}
    },
    "hide_end": {
        "description": "You hide successfully and avoid danger. You survive… for now. You WIN!",
    },
    "forward_end": {
        "description": "You move forward and run into a gang. They chase you away. You lose.",
    }
}

# Start the game
name = input("Type your name: ")
print(f"\nWelcome, {name}, to the apocalypse adventure!")
play_adventure(apocalypse_story)
