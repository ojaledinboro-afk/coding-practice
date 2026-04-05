names = []

if not names:
  choice = input("There are no names to view would you like to add some? (Y/N) ")
  if choice.lower() == "y":
    print("We are in Add Mode. To quit type: Quit")
    print("Press Enter after each name to input a new one.")
    while True:
      name = input("Enter Name: ")
      if name.lower() == "quit":
        break
      else:
        names.append(name)
        continue
  elif choice.lower() == "n":
    print("No names were added. Quitting...")
    exit()

while True:
  choice = input("Would you like to view the names? (Y/N) ")
  if choice.lower() == "y":
    print("We are in View Mode.")
    for i in range(len(names)):
      print(f"{i + 1}. {names[i]}")
    
    print("\nEnd of List")
    print("Quitting...")
    exit()
  elif choice.lower() == "n":
    print("Quitting...")
    exit()
  else:
    print("Not a Valid Option")
    continue