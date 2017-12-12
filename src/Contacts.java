import java.util.Scanner;

public class Contacts {
	static int noContacts = 0;
	static boolean inputContactsDone = false;

	static String[][] data = new String[0][0];
	static int addedContacts = data.length;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		numberOfContacts();
		inputContacts();
		while (inputContactsDone == true) {
				System.out.println("Press 1 to add a contact, 2 to search for a contact, "
						+ "3 to edit a contact, or 0 exit");
				Scanner input = new Scanner(System.in);
				String input2 = input.next();
				if(input2.equals("1")) {
					numberOfContacts();
					inputContacts();
				} else if(input2.equals("2")) {
					search();
				} else if(input2.equals("3")) {
					editContact();
				} else if(input2.equals("0")) {
					break;
				} else {
					System.out.println("Please enter a valid number");
					
				}
		
		}
	}
	//Find initial number of contacts or the number to be added
	public static void numberOfContacts() {
		System.out.println("Enter the number of contacts you would like to add");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		noContacts = input.nextInt();
		addedContacts = data.length;
		if(noContacts >= 0) {
			String[][] temp = new String[data.length + noContacts][4];
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					temp[i][j] = data[i][j];
				}
			}
			data = temp;
		} else {
			System.out.println("Enter a valid number");
			numberOfContacts();
		}
	}
	
	
	public static void inputContacts() {
		if(inputContactsDone) {
			for (int i = 0; i < noContacts; i++) {
				System.out.println("Enter the name of the new contact");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				data[i + addedContacts][0] = input.next();
				String name = data[addedContacts + i][0] + "'s";
				
				System.out.println("Enter " + name + " contact number");
				@SuppressWarnings("resource")
				Scanner input1 = new Scanner(System.in);
				data[addedContacts + i][1] = Integer.toString(input1.nextInt());
				
				System.out.println("Enter " + name + " email address");
				@SuppressWarnings("resource")
				Scanner input2 = new Scanner(System.in);
				data[addedContacts + i][2] = input2.next();
				
				System.out.println("Enter " + name + " address");
				@SuppressWarnings("resource")
				Scanner input3 = new Scanner(System.in);
				data[addedContacts + i][3] = input3.next();
				
				System.out.println("Contact created!");
			}
		}
		if(!inputContactsDone) {
			for (int i = 0; i < noContacts; i++) {
				System.out.println("Enter the name of the new contact");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				data[i][0] = input.next();
				String name = data[i][0] + "'s";
				
				System.out.println("Enter " + name + " contact number");
				@SuppressWarnings("resource")
				Scanner input1 = new Scanner(System.in);
				data[i][1] = Integer.toString(input1.nextInt());
				
				System.out.println("Enter " + name + " email address");
				@SuppressWarnings("resource")
				Scanner input2 = new Scanner(System.in);
				data[i][2] = input2.next();
				
				System.out.println("Enter " + name + " address");
				@SuppressWarnings("resource")
				Scanner input3 = new Scanner(System.in);
				data[i][3] = input3.next();
				
				System.out.println("Contact created!");
			}
			
		}
		inputContactsDone = true;
	}
	
	@SuppressWarnings("resource")
	public static void editContact() {
		System.out.println("Enter the name of the contact you would like to edit information of");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		boolean found = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i][0].equals(name)) {
				found = true;
				System.out.println("Contact number: " + data[i][1]);
				System.out.println("Email address: " + data[i][2]);
				System.out.println("Address: " + data[i][3]);
				System.out.println("Press 1 to edit the contact number, 2 for Email Address and 3 for Address");
				Scanner input2 = new Scanner(System.in);
				int detail = input2.nextInt();
				if (detail == 1) {
					System.out.println("Please enter the new contact number");
					Scanner input3 = new Scanner(System.in);
					String newDetail = input3.next();
					data[i][1] = newDetail;
				} else if (detail == 2) {
					System.out.println("Please enter the new email address");
					Scanner input3 = new Scanner(System.in);
					String newDetail = input3.next();
					data[i][2] = newDetail;
				} else if (detail == 3) {
					System.out.println("Please enter the new address");
					Scanner input3 = new Scanner(System.in);
					String newDetail = input3.next();
					data[i][3] = newDetail;
				} else {
					System.out.println("Please enter a valid number");
				}
				break;
			}
		} if (!found) {
			System.out.println("No contacts match this name");
		}
	}
	
	@SuppressWarnings("resource")
	public static void search() {
		System.out.println("Enter the name of the contact you would like to search the information of");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		boolean found = false;
		for (int i = 0; i < data.length; i++) {
			if (data[i][0].equals(name)) {
				found = true;
				System.out.println("Contact number: " + data[i][1]);
				System.out.println("Email address: " + data[i][2]);
				System.out.println("Address: " + data[i][3]);
			}
		}
		if(!found) {
			System.out.println("Contact not found");
		}
	}	
}