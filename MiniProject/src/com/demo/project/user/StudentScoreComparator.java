package com.demo.project.user;

import java.util.Comparator;

public class StudentScoreComparator implements Comparator<StudentScore> {
	@Override
	public int compare(StudentScore studentScore1, StudentScore studentScore2) {
		return Integer.compare(studentScore2.getScore(), studentScore1.getScore());
	}

	public int compareAscending(StudentScore studentScore1, StudentScore studentScore2) {
		return Integer.compare(studentScore1.getScore(), studentScore2.getScore());
	}

}
