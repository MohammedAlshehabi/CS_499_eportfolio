# cs320
How can I make sure my code, program, or software is functional and secure?
To keep my code functional and secure, I follow best practices like unit testing, boundary testing, and exception handling. In my project, I used JUnit tests to check that my code worked correctly and met constraints. For example, my tests in ContactServiceTest.java verified that contacts could be added, updated, and deleted while enforcing rules like ID uniqueness and required fields. To improve security, I focus on input validation to prevent issues like invalid data entries. If a user tries to input an incorrect phone number or an address that’s too long, my code trims or rejects the input instead of allowing bad data to pass through.

How do I interpret user needs and incorporate them into a program?
Understanding what users need starts with defining clear requirements and translating them into features. In this project, user needs were centered around contact management, so I built a system that allowed users to create, update, delete, and retrieve contacts easily. To match real-world expectations, I enforced constraints like first and last names being limited to 10 characters, phone numbers being exactly 10 digits, and addresses not exceeding 30 characters. The ContactService.java file reflects these needs by providing straightforward methods to interact with contacts, making the system simple to use.

How do I approach designing software?
I start with a modular approach, breaking the system into smaller components that handle specific tasks. For example, I separated Contact, ContactService, and unit tests into different files to keep the code organized and maintainable. Before coding, I think about data structures and constraints, ensuring that each component is structured correctly. I also use test-driven development (TDD) to catch potential errors early, writing tests first and then implementing functionality. This approach helps ensure that every feature works as expected before moving forward.

Through this project, I strengthened my understanding of unit testing, validation, and structured software development, making my code more reliable and easier to maintain.
