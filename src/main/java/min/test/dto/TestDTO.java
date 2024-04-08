package min.test.dto;

public class TestDTO {
	// 프로퍼티
	private String name = "홍길동";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public TestDTO(String name) {
		super();
		this.name = name;

	}
}
