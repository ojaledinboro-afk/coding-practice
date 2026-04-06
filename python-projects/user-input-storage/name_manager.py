import os

FILE_NAME = "names.txt"

def load_names():
    """Load names from a file into a list."""
    if not os.path.exists(FILE_NAME):
        return []
    with open(FILE_NAME, "r") as file:
        return [line.strip() for line in file if line.strip()]

def save_names(names):
    """Save the current list of names to a file."""
    with open(FILE_NAME, "w") as file:
        for name in names:
            file.write(f"{name}\n")

def add_names(names):
    print("\nAdd Mode: Type 'Quit' to stop adding names.")
    while True:
        name = input("Enter Name: ").strip()
        if name.lower() == "quit":
            break
        elif name == "":
            print("Empty name, please enter a valid name.")
        else:
            names.append(name)
            print(f"'{name}' added.")
    save_names(names)

def view_names(names):
    if not names:
        print("\nNo names to display.")
        return
    print("\nView Mode:")
    for idx, name in enumerate(names, start=1):
        print(f"{idx}. {name}")
    print("End of List.")

def remove_name(names):
    if not names:
        print("\nNo names to remove.")
        return
    view_names(names)
    choice = input("Enter the number of the name to remove (or 'Cancel'): ").strip()
    if choice.lower() == "cancel":
        return
    if not choice.isdigit() or not (1 <= int(choice) <= len(names)):
        print("Invalid selection.")
        return
    removed = names.pop(int(choice) - 1)
    print(f"'{removed}' has been removed.")
    save_names(names)

def search_names(names):
    if not names:
        print("\nNo names to search.")
        return
    query = input("Enter a name to search: ").strip().lower()
    results = [name for name in names if query in name.lower()]
    if results:
        print("Search Results:")
        for name in results:
            print(f"- {name}")
    else:
        print("No matching names found.")

def main():
    names = load_names()
    print("Welcome to the Name Manager!\n")

    while True:
        print("\nMenu:")
        print("1. Add Names")
        print("2. View Names")
        print("3. Remove a Name")
        print("4. Search Names")
        print("5. Quit")
        choice = input("Select an option (1-5): ").strip()

        if choice == "1":
            add_names(names)
        elif choice == "2":
            view_names(names)
        elif choice == "3":
            remove_name(names)
        elif choice == "4":
            search_names(names)
        elif choice == "5":
            print("Goodbye!")
            break
        else:
            print("Invalid option. Please enter a number from 1 to 5.")

if __name__ == "__main__":
    main()
