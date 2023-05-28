package com.demo.project.user;

public class StudentScore {
	private StudentEntry studententry;
	private int score;

	public StudentScore(StudentEntry studententry, int score) {
		this.studententry = studententry;
		this.score = score;
	}

	public StudentEntry getStudent() {
		return studententry;
	}

	public int getScore() {
		return score;
	}
}
