package min.dept.dto;

public class DeptDTO {
// private 지정어로 deptno 인스턴스 변수를 선언하고 외부에서 직접 접근하여 수정하지 못하도록 은닉화 한다.
	private int deptno;
// private 지정어로 dname 인스턴스 변수를 선언하고 외부에서 직접 접근하여 수정하지 못하도록 은닉화 한다.
	private String dname;
// private 지정어로 loc 인스턴스 변수를 선언하고 외부에서 직접 접근하여 수정하지 못하도록 은닉화 한다.
	private String loc;

// deptno 인스턴스 변수로 부서 번호를 호출한다.
	public int getDeptno( ) {
		return deptno;
	}

// deptno 인스턴스 변수로 부서 번호를 수정하여 임시로 저장한다.
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

// dname 인스턴스 변수로 부서 이름을 호출한다.
	public String getDname( ) {
		return dname;
	}

// dname 인스턴스 변수로 부서 이름을 수정하여 임시로 저장한다.
	public void setDname(String dname) {
		this.dname = dname;
	}

// loc 인스턴스 변수로 부서 지역을 호출한다.
	public String getLoc( ) {
		return loc;
	}

// loc 인스턴스 변수로 부서 지역을 수정하여 임시로 저장한다.
	public void setLoc(String loc) {
		this.loc = loc;
	}

// 데이터를 검증한다.
	@Override
	public String toString( ) {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
}