package br.inf.prismasoft.academix.helper;

import java.util.List;

public class GradeHorariaHelper {
	
	public List<GradeHorariaItemHelper> gradeList;
	
	public GradeHorariaHelper(List<GradeHorariaItemHelper> list) {
		this.gradeList = list;
		
	}

	public List<GradeHorariaItemHelper> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<GradeHorariaItemHelper> gradeList) {
		this.gradeList = gradeList;
	}

}
