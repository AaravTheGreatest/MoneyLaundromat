import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class moneyLaundromat {
	public static void main (String[] args) {
        ArrayList<person> people = new ArrayList<>();
        ArrayList<machine> machines = new ArrayList<>();
		boolean running = true, ring = false;
        char op;
        String name;
        double money;
        int status, value;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the money laundromat! This is definetely NOT a money laundering scheme.\n");
        do {
            System.out.println("Enter an option (h for help, q to quit (doesn't save progress, be warned!)): ");
            op = in.next().charAt(0);
            switch (op) {
                case 'h':
                    System.out.println("HELP MENU:\nc: create an object/character\nd: delete an object/character\nm: perform actions on an object/character\nq: quit game");
                    break;
                case 'c':
                    System.out.println("Would you like to create a general person (p), a cop (c), a ringmaster (r), or a laundry machine (m)? ");
                    op=in.next().charAt(0);
                    switch (op) {
                        case 'p':
                            System.out.println("What's your person's name? ");
                            in.nextLine(); // clear buffer
                            name = in.nextLine();
                            System.out.println("How much money does " + name + " get to start with? ");
                            money = in.nextDouble();
                            person p = new person(name, money);
                            people.add(p);
                            System.out.println("Successfully created person " + name + " with $" + money + ".\n");
                            break;
                        case 'r':
                            if (!ring) {
                                System.out.println("What's your ringmaster's name? ");
                                in.nextLine(); // clear buffer
                                name = in.nextLine();
                                System.out.println("How much money does " + name + " get to start with? ");
                                try { money = in.nextDouble(); }
                                catch (InputMismatchException e) { System.out.println("Invalid input, please try agian."); break; }
                                System.out.println("How worried is " + name + "? ");
                                try { status = in.nextInt(); }
                                catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                                System.out.println("How much money can their vault store? ");
                                try { value = in.nextInt(); }
                                catch (InputMismatchException e) { System.out.println("Invalid input, please try again!"); break; };
                                ringmaster r = new ringmaster(name, money, status, value);
                                people.add(r);
                                System.out.println("Successfully created ringmaster " + name + " with $" + money + " and " + status + " worry.\n");
                                ring = true;
                            }
                            else System.out.println("You already have a ringmaster!\n");
                            break;
                        case 'c':
                            System.out.println("What's your cop's name? ");
                            in.nextLine(); // clear buffer
                            name = in.nextLine();
                            System.out.println("How much money does " + name + " get to start with? ");
                            try { money = in.nextDouble(); }
                            catch (InputMismatchException e) { System.out.println("System.out.println"); break; }
                            System.out.println("How suspicious is " + name + "? ");
                            status = in.nextInt();
                            if (status > 10) {
                              System.out.println("Too high! Max suspicion level is 10. Setting to 10.");
                              status = 10;
                            }
                            cop c = new cop(name, money, status);
                            people.add(c);
                            System.out.println("Successfully created cop " + name + " with $" + money + " and " + status + " suspicion.\n");
                            break;
                        case 'm':
                            System.out.println("How much money is in your launderi- LAUNDRY machine to start with?");
                            try { money = in.nextDouble(); }
                            catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                            machine m = new machine(money);
                            machines.add(m);
                            System.out.println("Successfully created laundry machine with $" + money + ".\n");
                            break;
                        default:
                            System.out.println("That isn't a valid option.\n");
                    }
                    break;
                case 'd':
                    System.out.println("Would you like to delete a person (p) or a machine (m)? ");
                    op = in.next().charAt(0);
                    switch(op) {
                      case 'p':
                        for (int i = 1; i <= people.size(); i++) System.out.println(i + ") " + people.get(i - 1));
                        System.out.println("Choose a number to delete (0 to cancel) ");
                        value = in.nextInt();
                        if (value == 0) break;
                        if (value < 0 || value > people.size()) System.out.println("Invalid number, try again.");
                        if (value > 0 && value <= people.size()) {
                          System.out.println("Deleted " + people.get(value - 1).getName() + ".");
                          if (people.get(value - 1).getType() == "ringmaster") ring = false;
                          people.remove(value - 1);
                        }
                        break;
                      case 'm':
                        for (int i = 1; i <= machines.size(); i++) System.out.println(i + ") " + machines.get(i - 1) + " with $" + machines.get(i - 1).getMoney());
                        System.out.println("Choose a number to delete (0 to cancel)");
                        value = in.nextInt();
                        if (value == 0) break;
                        if (value < 0 || value > machines.size()) System.out.println("Invalid number, try again.");
                        if (value > 0 && value <= machines.size()) {
                          System.out.println("Deleted machine with ID: " + machines.get(value - 1));
                          machines.remove(value - 1);
                        }
                      default:
                        System.out.println("Invalid option, please try again!");
                    }
                    break;
                case 'q':
                    System.out.println("Thanks for playing, goodbye!");
                    running = false;
                    break;
                case 'm':
                  System.out.println("Perform an action on a person (p) or a machine (m)? ");
                  op = in.next().charAt(0);
                  switch (op) {
                    case 'p':
                      for (int i = 1; i <= people.size(); i++) System.out.println(i + ") " + people.get(i - 1));
                      System.out.println("Input the number of the person you'd like to perform an action on (0 to quit): ");
                      // if (!(value = in.nextInt())) System.out.println("Invalid input"); got too lazy for actual error handling, this didn't work because java scanner's a hater
                      try { value = in.nextInt(); }
                      catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                      if (value == 0) break;
                      if (value < 0 || value > people.size()) System.out.println("Invalid number, try again.");
                      if (value > 0 && value <= people.size()) {
                        if (people.get(value - 1).getType() == "person") {
                          System.out.println("Actions:\nGeneral actions:\n\t1) Get information\nMoney actions:\n\t2) Get money\n\t3) Use a laundry machine");
                          try { status = in.nextInt(); }
                          catch (InputMismatchException e) { System.out.println("Invalid input, please try again! "); value = 0; /*Setting value to zero triggers the break right after this*/ break; /* Nevermind, doesn't like uninit var */}
                          switch (status) {
                            case 1:
                              System.out.println(people.get(value - 1));
                              break;
                            case 2:
                              System.out.println(people.get(value - 1).getMoney());
                              break;
                            case 3:
                              for (int i = 1; i <= machines.size(); i++) System.out.println(i + ") " + machines.get(i - 1));
                              System.out.println("Which machine would you like to use (0 to quit)? ");
                              try { status = in.nextInt(); }
                              catch (InputMismatchException e) {System.out.println("Invalid input, please try again."); break; }
                              if (status == 0) break;
                              if (status < 0 || status > machines.size()) System.out.println("Invalid number, try again.");
                              if (status > 0 && status <= machines.size()) {
                                System.out.println("Using a machine costs $5. Now depositing $5.");
                                if ((people.get(status - 1).getMoney()) > 5) {
                                  people.get(value - 1).subMoney(5);
                                  machines.get(status - 1).useMachine(5);
                                }
                                else System.out.println("This person doesn't have enough to use the machine!");
                              }
                              break;
                            default:
                              System.out.println("That's an invalid option, try again!");
                              break;
                          }
                        }
                        if (people.get(value - 1).getType() == "ringmaster") {
                          System.out.println("Actions:\nGeneral actions:\n\t1) Get information\nMoney actions:\n\t2) Get money from laundry machine\nWorry actions:\n\t3) Get worry level\n\t4) Add worry\n\t5) Reduce worry");
                          try { status = in.nextInt(); }
                          catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                          switch (status) {
                            case 1:
                              System.out.println(people.get(value - 1));
                              break;
                            case 2:
                              for (int i = 1; i <= machines.size(); i++) System.out.println(i + ") " + machines.get(i - 1));
                              System.out.println("Which machine would you like to use (0 to quit)? ");
                              try { status = in.nextInt(); }
                              catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                              if (status == 0) break;
                              if (status < 0 || status > machines.size()) System.out.println("Invalid number, try again.");
                              else {
                                System.out.println("Now collecting money from machine " + machines.get(status - 1));
                                people.get(value - 1).addMoney(machines.get(status - 1).getMoney());
                                machines.get(status - 1).setMoney(0);
                              }
                          }
                        }
                        if (people.get(value - 1).getType() == "cop") {
                          System.out.println("Actions:\nGeneral actions:\n\t1) Get information\nMoney actions:\n\t2) Check money\nSuspicion options:\n\t3) Get suspicion\n\t4) Add suspicion\n\t5) Remove suspicion\nLaw actions:\n\t6) Search person");
                          try { status = in.nextInt(); }
                          catch (InputMismatchException e) { System.out.println("Invalid input, please try again."); break; }
                          switch (status) {
                            case 1:
                              System.out.println(people.get(value - 1));
                            case 2:
                              System.out.println(people.get(value - 1).getMoney());
                            case 3:
                              // System.out.println((people.get(value - 1).getType() == "cop") ? (cop) people.get(value - 1).getSus() : "");
                              if (people.get(value - 1).getType() == "cop") {
                                cop c = (cop) people.get(value - 1);
                                System.out.println(c.getSus());
                              }
                              else System.out.println("This person isn't a cop");
                            case 4:
                              // System.out.println((people.get(value - 1).getType() == "cop") ? ((cop) people.get(value - 1).getSus() != 10) ? "Increasing suspicion by 1" : "Your cop's suspicion value is already too high! (max 10)" : "");
                              if (people.get(value - 1).getType() == "cop") {
                                cop c = (cop) people.get(value - 1);
                                if (c.getSus() <= 10) c.addSus(1);
                                else System.out.println("Your cop's suspicion level's too high! (max 10)");
                              }
                            case 5:
                              System.out.println("Decrementing suspicion by 1.");
                              if (people.get(value - 1).getType() == "cop") {
                                cop c = (cop) people.get(value - 1);
                                if (c.getSus() == 0) System.out.println("You can't have negative suspicion.");
                                else c.removeSus(1);
                              }
                            case 6:
                              for (int i = 1; i <= people.size(); i++) System.out.println(i + ") " + people.get(i - 1));
                              System.out.println("Who would you like to search? ");
                              try { status = in.nextInt(); }
                              catch (InputMismatchException e) { System.out.println("Invalid option, please try again."); break; }
                              if (status == 0) break;
                              if (status <= 0 || status > people.size()) System.out.println("Invalid number, please try again.");
                              else {
                                // if ((cop) ((people.get(value - 1).search(people.get(status - 1))) >= ((cop) (people.get(value - 1).getSus()) * 100)) && people.get(status - 1).getType() == "ringmaster" && people.get(value - 1) instanceof cop) { System.out.println("You've caught the ringmaster red handed, good job!"); return; }
                                if (people.get(value - 1).getType() == "cop") {
                                  cop c = (cop) people.get(value - 1);
                                  if ((c.search(people.get(status - 1)) > ((10 - c.getSus()) * 100)) && people.get(status - 1).getType() == "ringmaster") {
                                    System.out.println("You've caught the ringmaster red handed!");
                                    return;
                                  }
                                  else System.out.println("Not enough evidence to arrest them...");
                                }
                                else System.out.println("You're not even a cop!");
                              }
                          }
                        }
                      }
                 }
                 break;
                case 't': // for testing
                    for (person i: people) System.out.println(i);
                    break;
                default:
                    System.out.println("Invalid option, please try again. 'h' for help menu.");
            }
        } while (running);
        in.close();
	}
}
