# Game Tester Log
-	Developer: Likhona Ngwenya
-	Student Number: ST10446272
-	Group: GR01
-	Course: Higher Certificate in Mobile Application and Web Development (HMAW0501)
-	Subject: IMAD5112
## Links
•	GitHub Repository: https://github.com/ST10446272/Game-Tester-Log


## Project Overview
The Game Tester App is a mobile application developed as part of an assignment in the IMAD5112 subject. This application was created using Kotlin and Android Studio. The app's primary purpose is to allow game testers to log their daily play sessions over a one week period. The data is used to assess trends in gameplay habitats, ratings, and perfrences. The app was developed to meet the requirements of the assignment, which includes creating a functional mobile app and utilizing GitHub for version control and CI/CD automation using GitHub Actions.

## Error Handling 
-  Prevent empty fields or invalid data entries 
- Validation of numeric inputs 


## Functionality 
- Used loop to iterate through arrays 
- Use statements to output messages and insights based on the genre and ratings 
- Restricted data entry to max 7 entries
- Navigation between screens using intent
- Display data in a readable layout 
- Allow clear fields
- Show feed back 

## App Purpose & Functionality
- The app appears to be a game tracking and rating tool, likely for personal use or light analytics. Users can:
- Enter game session data (date, minutes played, genre, and rating).
- Store multiple entries.
	-- View overall statistics:
	--Total minutes played.
	--Highest-rated game and genre.
	--Average minutes per day.

## Design Choices Explained
### 1. Color Theme & Visual Style
- Dominant pink overlay with a semi-transparent background image from Call of Duty.
- Typography: Large, bold header ("Bug Busters") for emphasis.
- Consisent color tone keeps visual cohesion but may affect readability due to low contrast.

### 2. Form Design (First Screen)
Date Picker: Scroll-style, intuitive for mobile users.
TextField for Minutes Played: Minimalist underline-only style.
Dropdown for Genre: Clearly labeled "Sports" as an example.
Rating System: Simple radio buttons (1–5) for quick selection.

Buttons:
- Add Entry: Saves data.
- Clear: Resets the form.
- View Details: Navigates to the second screen for analysis.

### 3. Statistics View (Second Screen)
Clean separation of:
- Total minutes played.
- Highest-rated game and genre.
- Average minutes per day.

User entry listing shows:
- Date
- Minutes
- Genre
- Rating

### Navigation Buttons:
-Back: Likely returns to the entry screen.
-Exit: Exits the app or closes the view.



## Screenshots
### App Screenshots:
Screenshot 1: MainActivity.kt  -> ![Splash Screen](https://github.com/user-attachments/assets/553be6fe-6352-4a80-b82b-eca4ac014402)

Screenshot 2: MainActivity2.kt  -> ![Main Activity](https://github.com/user-attachments/assets/333c7d24-ad14-47b0-8bd4-53ea6f31c242)

Screenshot 3: MainActivity2.kt  -> ![View Activity](https://github.com/user-attachments/assets/f578f540-ee77-47d7-a691-3fb8e2bbec18)

## References
1.	Reference 1: https://za.pinterest.com/pin/292311832083504339/
2.	Reference 2: https://www.geeksforgeeks.org/datepicker-in-kotlin/
3.	Reference 3: https://www.geeksforgeeks.org/exposed-drop-down-menu-in-android/
4.	Reference 4: https://www.geeksforgeeks.org/radiobutton-in-kotlin/ 
5.	Reference 5: https://za.pinterest.com/pin/80079699618054976/
6.	Reference 6: https://www.pexels.com/photo/red-strawberries-and-stainless-steel-spoons-on-a-black-surface-8019484/
7.	List of Figures



