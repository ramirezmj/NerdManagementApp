package edu.jmramirez.nerdmanagementapp.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.jmramirez.nerdmanagementapp.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * {@link UserDataMock} class for generating test user and course data
 */
public class UserDataMock {
	
	private static UserDataMock INSTANCE;
	
	public static UserDataMock newInstance(Context context) {
		
		if ( INSTANCE == null ) {
			INSTANCE = new UserDataMock(context);
		}
		
		return INSTANCE;
	}
	
	private final Context			context;
	private final List<UserData> 	userDataList;
	private final List<CourseData> 	courseDataList;
	
	private  UserDataMock(Context context) {
		this.context = context;
		this.courseDataList = initializeCourseData();
		this.userDataList = initializeUserData(this.courseDataList);
	}
	
	/**
	 * Returns a list of mock users.
	 * 
	 * @return A list of {@link UserData} objects.
	 */
	public List<UserData> getUserList() {
		
		return this.userDataList;
	}
	
	/**
	 * Returns a single {@link UserData} entity.
	 * 
	 * @param position The index of the object in the List.
	 * 
	 * @return A {@link UserData} entity representing a single user.
	 */
	public UserData getUserAt(int position) {
		
		return this.userDataList.get(position);
	}
	
	/**
	 * Returns a list of {@link CourseData} entities for a particular user.
	 * 
	 * @param userId The index or ID of the {@link UserData} object from which we 
	 * 					want to obtain the courses list.
	 * 
	 * @return A collection of {@link CourseData} entities for this particular user.
	 */
	public List<CourseData> getCoursesForUser(int userId) {
		
		return this.userDataList.get(userId).getEnrolledCourses();
	}
	
	private List<CourseData> initializeCourseData() {
		List<CourseData> courseDataMockList = new ArrayList<CourseData>();
		
		courseDataMockList.add(
				new CourseData(
						"CS 100. Computational Thinking I",
						6,
						"Mon, Tue, Wed, Thu, Fri",
						"10:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 101. Fluency With Information Technology",
						3,
						"Mon, Wed, Thu, Fri",
						"12:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 109. Smart Phone and Wireless Technology",
						3,
						"Mon, Thu, Fri",
						"15:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 199. Special Topcs: Outreach Training",
						6,
						"Mon, Tue, Wed, Thu",
						"09:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 200. Computational Thinking II",
						6,
						"Mon, Wed, Fri",
						"17:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 201. Introduction to Object Oriented Programming",
						9,
						"Tue, Thu",
						"14:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 250. Discrete Structures",
						4,
						"Mon",
						"15:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 302. Object-Oriented Design",
						4,
						"Tue",
						"16:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 303. Algorithms/Data Structures",
						6,
						"Mon, Thu, Fri",
						"08:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 304. Object-Oriented Programming in C++",
						4,
						"Tue, Wed, Fri",
						"10:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 305. Introduction to Python Programming",
						3,
						"Mon, Thu",
						"17:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 330. Computer Organization and Assembly Language Programming",
						3,
						"Tue, Fri",
						"14:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 333. Unix Operating System Fundamentals",
						2,
						"Wed",
						"12:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 334. Internetworking with TCP/IP",
						6,
						"Mon, Thu, Fri",
						"16:00")
				);
		courseDataMockList.add(
				new CourseData(
						"CS 336. Network Security",
						6,
						"Tue, Wed, Fri",
						"18:00")
				);
		
		return courseDataMockList;
	}

	private List<UserData> initializeUserData(List<CourseData> courseDataMockList) {
		List<UserData> userDataMockList = new ArrayList<UserData>();
		Random randomGenerator = new Random();
		int MAX_RAND_NUM = courseDataMockList.size();
		
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.fry),
						"Philip J. Fry",
						"1", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.leela),
						"Turanga Leela",
						"2", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.bender),
						"Bender Bending Rodriguez",
						"3", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.amy),
						"Amy Wong",
						"4", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.mom),
						"Mom",
						"5", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.farn),
						"Professor Hubert J. Farnsworth",
						"6", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.zoidberg),
						"Doctor John Zoidberg",
						"7", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.nibbler),
						"Lord Nibbler",
						"8", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.zapp),
						"Zapp Brannigan",
						"9", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		userDataMockList.add(
				new UserData(
						BitmapFactory.decodeResource(context.getResources(), R.mipmap.kif),
						"Kif Kroker",
						"10", 
						courseDataMockList.subList(0, randomGenerator.nextInt(MAX_RAND_NUM)))
				);
		
		return userDataMockList;
	}
	
	/**
	 * {@link UserData} class for storing user data.
	 */
	public static class UserData {

		private Bitmap 				picture;
		private String 				fullName;
		private String 				niu;
		private List<CourseData> 	enrolledCourses;

		
		public UserData() {
		}

		public UserData(Bitmap picture, String fullName, String niu,
				List<CourseData> enrolledCourses) {
			this.picture = picture;
			this.fullName = fullName;
			this.niu = niu;
			this.enrolledCourses = enrolledCourses;
		}

		public Bitmap getPicture() {
			return picture;
		}
		
		public void setPicture(Bitmap picture) {
			this.picture = picture;
		}
		
		public String getFullName() {
			return fullName;
		}
		
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		
		public String getNiu() {
			return niu;
		}
		
		public void setNiu(String niu) {
			this.niu = niu;
		}
		
		public List<CourseData> getEnrolledCourses() {
			return enrolledCourses;
		}
		
		public void setEnrolledCourses(List<CourseData> enrolledCourses) {
			this.enrolledCourses = enrolledCourses;
		}
		
		@Override public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append("***** User Data details *****\n");
			stringBuilder.append("picture=" + this.getPicture() + "\n");
			stringBuilder.append("fullName=" + this.getFullName() + "\n");
			stringBuilder.append("niu=" + this.getNiu() + "\n");
			stringBuilder.append("enrolledCourses=" + this.getEnrolledCourses().size() + "\n");
			stringBuilder.append("*****************************");
			
			return stringBuilder.toString();
		}
	}
	
	/**
	 * {@link CourseData} class for storing course data.
	 */
	public static class CourseData {

		private String 		title;
		private int 		numberOfCredits;
		private String 		daysOfWeek;
		private String 		startsAt;
		
		
		public CourseData() {
		}

		public CourseData(String title, int numberOfCredits, 
				String daysOfWeek, String startsAt) {
			this.title = title;
			this.numberOfCredits = numberOfCredits;
			this.daysOfWeek = daysOfWeek;
			this.startsAt = startsAt;
		}
		
		public String getTitle() {
			return title;
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public int getNumberOfCredits() {
			return numberOfCredits;
		}
		
		public void setNumberOfCredits(int numberOfCredits) {
			this.numberOfCredits = numberOfCredits;
		}
		
		public String getDaysOfWeek() {
			return daysOfWeek;
		}
		
		public void setDaysOfWeek(String daysOfWeek) {
			this.daysOfWeek = daysOfWeek;
		}
		
		public String getStartsAt() {
			return startsAt;
		}
		
		public void setStartsAt(String startsAt) {
			this.startsAt = startsAt;
		}
		
		@Override public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append("***** Course Data details *****\n");
			stringBuilder.append("title=" + this.getTitle() + "\n");
			stringBuilder.append("numberOfCredits=" + this.getNumberOfCredits() + "\n");
			stringBuilder.append("daysOfWeek=" + this.getDaysOfWeek() + "\n");
			stringBuilder.append("startsAt=" + this.getStartsAt() + "\n");
			stringBuilder.append("*****************************");
			
			return stringBuilder.toString();
		}
	}
}
