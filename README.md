Morax September 19th 3:30 PM Meeting
Attendance:
Sashti
Jordan
Zachary
Zoli

Updates:-
2 Epic and User stories should be done within wednesday before the in person meeting
Jordan said he is working on the features
Login page to be made as well for future updates
Jordan - Creating a 'task' object with attributes corresponding to the task as well as a 'taskList' container to hold/sort all current tasks.
Location services are not possible and it's difficult to implement.
Sashti and Zoli - Creating a web page with sql database
Zaccary - Helping with the UI once it's designed with Mehrad.
Possibility of implementing this on a docker image.


Persona 1: Carl Johnson
Age: 27
Job: A business manager, single, 2 cats
Carl Johnson is a business manager for 2 different companies and he wants to keep everything in his business and life in check, so he pulled out his phone to try __ and see how to create a schedule. As a manager for many years, he has adept knowledge of the internet and how to interface with most common forms of technology. He has a lot of stuff to manage, regarding his work and life.
Persona 2: Theodore Weaver

Age: 40

Job: Human Resources

Theodore’s job is in human resources, and he is married with children. He has a very dynamic schedule with meetings in groups or with a single person popping up all the time. Fixed events are not uncommon for him though, for example picking up his kids from school and extracurricular activities are an everyday occurrence. His motivations are being able to keep track of incoming information from employers and co-workers, and giving everyone the attention they need. Frustrations include many sources having the same problem, and too many tasks on the go at once. Daily activities are hosting group meetings, individual meetings, receiving complaints, and taking care of his children. He is on his computer quite often and mainly uses his web browser for everything.

Persona 3: Chris 
Age: 32
Job: Human Resource worker, married 
Chris H.R. Rep II is a 32-year-old Human Resource worker. Married to 28-year-old barber John Isabarber, he and his husband live an average life with their Boston Terrier Chompers. Being a HR worker Chris meets with employees from all different positions within the company, helping with their problems while completing his own work as well. Chris wants Morax Management to keep him on track. Whether that be sorting his appointments, tracking his upcoming deadlines, or being able to view ahead of time what his next week will be filled with. Before Morax Management Chris would try to keep track of his schedule with sticky notes. This was never an effective option but that really came to light when he misplaced the note reminder for John’s birthday dinner reservation. After receiving a disappointed call from John when Chris didn’t show up, Chris decided to find a better method of management. Chris enjoys helping others (he volunteers at a food bank every other weekend) and watching movies with his partner. He doesn’t have the most technical prowess when it comes to computers but is well versed enough to use programs that are user friendly quite well.

Persona 4: Patrick Pre-med

Age: 22

Job:University student, unmarried 

Patrick Pre-med is 22 years old, full time student majoring in biomed, unmarried. His goals are to maintain a high average and to take the MCAT exam successfully, while expanding his network. He dreams of being a medical doctor. He is frustrated with a scattered studying schedule and the seemingly impossible workload, hard to keep track of when to meet people and who to meet. His activities are: study for 5 courses, going to classes and tutorials, and attending parties and meetings to further expand his connections. Very proficient in using technology.


Persona 5: Felix Brown

Age: 15

Job: High school student

Felix Brown is known for being very social and friendly with people from a very young age. Felix is also a sportsman. He regularly plays hockey for his school team. He wants to go out and enjoy his life with his friends and peers but he also feels like he is always busy and never free to do activities with others. Having so many friends and also taking so many classes, he is always worried about missing an assignment’s due date. Felix is looking for something that will help him maintain a higher average to achieve honor roll. Felix knows how to use a mobile phone but he is also inclined to learn something new if it is useful for him. 


Persona 6: David Monk Johnson

Age: 55

Job: Train Engineer, divorced, 2 children (adults now)

David Monk had a bad divorce with his ex-wife a few years back. Since then, he has felt that his life is falling apart. From spending a lot of time in therapy, with lawyers and in courts along with going to his job, he feels super stressed. Throughout the years, even though he has gotten better in his personal life, he feels he has to do and manage his time more efficiently. He wants to spend more time with his kids (who are now adults) but finds it difficult to make plans due to scheduling conflicts. He is inclined to have and maintain a healthy relationship with the remainder of his family. David does not have that much technical proficiency because he does not use much technology outside of his work. His son, Carl Johnson, recently started using __ app and recommends it to his dad.

Persona 7: Steve Family guy

Age: 34

Job: Bank Associate
married with two kids, middle class, needs to balance his work and life, being able to manage his busy work schedule while attending to his family and taking care of himself physically and mentally. Steve’s schedule is scattered and his busy life has left him stressed out everyday. Steve has tried to plan out his upcoming days by making notes but he needs a more structured and organized layout to manage his multi-dimensional life. It is hard for Steve to keep in mind all the upcoming events and he misses some of them from time to time. This has led him in an awkward position that balancing his life seems impossible to him. Steve goes to work from Monday to Friday and sometimes works overtime to get a promotion. He has many routines including morning Yoga and weight lifting after his work to unwind and take care of himself. In the evening, he spends time with his family and friends. His technical knowledge is reasonable.



Epic #1: I, Felix Brown, would like to be able to make plans for the day.

User stories:
→(Persona 5)(5 points) I, Felix Brown, want to be able to add things to my plan and have them sorted automatically by the due date, so that I can prioritize my activities.
Acceptance Criteria:
	Create new tasks
	Assign tasks a priority
	View tasks in order (ordered by due date)
	
→(Persona 5)(1 points) I, Felix Brown, want to search for when I have free time so that I can make plans with my friends and/or study plans.
Acceptance Criteria:
	Search for freetime
	Search for tasks within a specific time frame

Epic #2: I, David Monk Johnson, would like to be able to share and compare multiple schedules so that I can make plans with my children.
	→(Persona 6)(3 points) I, David Monk Johnson, need to be able to view and compare my childrens schedules with my own so that I can still maintain a  healthy relationship with them.
		Acceptance Criteria:
			Load multiple schedules
			Compare schedules by free time
			View multiple schedules at the same time
			Clear indication of which schedule is which

	→(Persona 6)(1 points) I, David Monk Johnson, need to be able to receive my childrens schedules so that I can see when they are busy.
		Acceptance Criteria:
			Share schedules without navigating the file structure
			Load multiple schedules
			Save multiple schedules

Epic #3: As Patrick Pre-med, I want to be able to track my productive work that I have done and compare it to my goal and other time periods, so that I am aware of my productivity and efficiency.
User Story 1 (5 points): I wish to keep record of the time I spent studying everyday and the progress I made in those time windows.
Acceptance criteria: An entry for each activity to set the actual time spent on it at the end of the day. 
User Story 2 (7 points): I want to have a chart made from my studying records that shows everyday total time spent and sketch it throughout last week, last two weeks, last month, etc.
Acceptance criteria: A progress chart has the option to change the time frame shown.
User Story 3 (2 points): I want to have a progress meter that can set my own units and progress goals.
Acceptance criteria: set a progress meter for each day and the ability to define the units and the maximum of the meter. Visualize the meter.

Epic #4: As Patrick Pre-med, I want to take notes of what people to meet and set regular meetings to maintain the connections.
User Story 1 (4 points): I want to keep a record of people I need to meet and assign them priorities, so that I use my time efficiently.
Acceptance criteria: Ability to input individuals as objects with attributes like priority. Visualize the list.
User Story 2 (6 points): I wish to schedule meetings with the people in my list, with specified location, time and day.
Acceptance criteria: create objects for meetings. Assign the meeting with the chosen person on the list. Having the option for the user to create meetings.
User Story 3 (3 points): I want to be able to specify how often I should meet a particular person, and remind me in advance.
Acceptance criteria: Assign each individual a time cycle. When the cycle ends, notify the user and reset the cycle

Epic #5: As Steve, I want to be able to schedule my time in advance and to balance the time I spend with my family and work.
➔   User Story 1 (4 points): I want to schedule events for a week with specified times and locations.
Acceptance Criteria: ability to set event objects for specific days and times, add attributes to each event such as location, time etc.
➔   User Story 2 (3 points) : Categorize my events as family, work, fitness etc. I want to be able to define my own categories too.
Acceptance Criteria: define different event objects with different attributes 
➔   User Story 3 (7 points): I wish to split the time I am gonna spend in different event categories so that I can balance my time and split it reasonably.
Acceptance criteria: ability to set a limit on how much each event category can take up time per week. 
Epic #6: As Theodore Weaver I want to organize and control my workflow so that every employee and my family feels they have the resources and attention they need.
User Story 1 (7 points): As a human resources employee, I want to be able to create an event for myself and the person I am meeting with so that my day runs smoothly and I am not tracking people down.
Acceptance Criteria 1:
‘add friend’ ability
pending friend requests, accepting friend requests
create items that are synced with a friend

Independent → yes, ie. when an event is created we just add it to 2 users
Negotiable → yes, it is not specified to be implemented a certain way
Valuable → yes, adding smoothness to the work-flow
Estimable → yes, inside ‘user’ class, have ‘friends’ attribute, can add events with friends
Small → yes, assuming ‘event’ is created
Testable → yes

User Story 2 (3 points): As a father, I want to be able to track my work-load and spread it out evenly across the week so that I don’t over-exert myself and have energy for my family.
Acceptance Criteria 2:
add difficulty points to a task
set max difficulty wanted for a day (sum of all events)
visualize difficulty of days with shading

Independent → yes, just an estimation of the ‘exertion’ of a task
Negotiable → yes
Valuable → spreads work evenly over the whole week
Estimable → yes, technically just an attribute
Small → yes
Testable → yes

Epic #7: As Carl Johnson, I want to be able to have multiple accounts for different areas of work.
7 points User Story #1: As a businessman with multiple aliases, I want to be able to have multiple personas to separate different parts of my work and personal life.
2 points User Story #2: I want to be able to edit my alias and my personal details for my account




The picked User Stories/backlog:

#1 (5 points) I, Felix Brown, want to be able to add things to my plan and have them sorted automatically by the due date, so that I can prioritize my activities.
Acceptance Criteria:
Create new tasks
Assign tasks a priority
View tasks in order (ordered by due date)



	#2 (3 points) : I, Patrick pre-med, want to Categorize my events as family, work, fitness etc. I want to be able to define my own categories too.
Acceptance Criteria: define different event objects with different attributes 
 #3 (7 points): I, Steve Family Guy, wish to split the time I am gonna spend in different event categories so that I can balance my time and split it reasonably.
Acceptance criteria: ability to set a limit on how much each event category can take up time per week.
	#4 (1 points) I, Felix Brown, want to search for when I have free time so that I can make plans with my friends and/or study plans.
Acceptance Criteria:
Search for freetime
Search for tasks within a specific time frame
	#5 (5 points): I, Patrick Pre-med, wish to keep a record of the time I spent studying everyday and the progress I made in those time windows.
Acceptance criteria: An entry for each activity to set the actual time spent on it at the end of the day. 
#6 (7 points): I, Patrick Pre-med,  want to have a chart made from my studying records that shows everyday total time spent and sketch it throughout last week, last two weeks, last month, etc.
	Acceptance Criteria:
		View time spent on activities
		Have time spent graphed
		View graph over differing amounts of time
		

#7 (4 points): I, Patrick Pre-med, want to keep a record of people I need to meet and
assign them priorities, so that I use my time efficiently.
Acceptance criteria: Ability to input individuals as objects with attributes like priority. Visualize the list.

	 #8 (7 points): I, Carl Johnson, a businessman with multiple aliases, want to be able to have multiple personas to separate different parts of my work and personal life.
		Acceptance Criteria:
			Login page
			
#9 (2 points): I, Carl Johnson, want to be able to edit my alias and my personal details for my accounts.
		Acceptance Criteria:
			Account page to view account details
			Edit account page


#10 (1 points) I, David Monk Johnson, need to be able to receive my childrens
schedules so that I can see when they are busy.
		Acceptance Criteria:
			Share schedules without navigating the file structure
			Load multiple schedules
			Save multiple schedules

Contributions: 
	Mehrad Hassanpour: 20%
	Sashti Prasad Narayanasami Natarajan: 20%
	Zackary Mowbray: 20%
Jordan Planchot: 20%
	Zoli Digness: 20%

Action Plan:


Sashti - A front page and a login page
Mehrad - The view part of the MVC - UI
Zackary - Create compact widgets for view
Zoli - Database and setting up a development environment
Jordan - Model and controller part of the MVC - backend


Prioritized Backlog:

Schedule, sort, prioritize activities in the calendar
Define new categories
Categorize events 
Set a time limit for different categories
Search for free time
Keep a record of time for the finished activities
A progress chart based on the progress report
Make a record of people to meet and assign priorities
Register/Login page for accounts
 Editing personal information 
 Having different calendars within the same account
 Ability to receive and view other peoples schedule and compare it to yours

