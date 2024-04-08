package min.dept.service;

import java.util.ArrayList;
import min.dept.dto.DeptDTO;

public interface DeptService {
//제네릭 DeptDTO 클래스 반환 자료형으로 연동할 인스턴스 변수를 전달하고 전체 데이터를 조회한다.
	public ArrayList<DeptDTO> deptSelectAll( );

//DeptDTO 클래스 반환 자료형으로 연동할 인스턴스 변수를 전달하고 특정 데이터를 조회한다.
	public DeptDTO deptSelect(int deptno);

//DeptDTO 클래스 반환 자료형으로 연동할 인스턴스 변수를 전달하고 데이터를 입력한다.
	public DeptDTO deptInsert(DeptDTO deptDTO);

//DeptDTO 클래스 반환 자료형으로 연동할 인스턴스 변수를 전달하고 데이터를 수정한다.
	public DeptDTO deptUpdate(DeptDTO deptDTO);

//DeptDTO 클래스 반환 자료형으로 연동할 인스턴스 변수를 전달하고 데이터를 삭제한다.
	public DeptDTO deptDelete(int deptno);
}
