package sei.tool;

public enum CharacterType {
	
	ENG("Ӣ��"),NUM("����"),CHZ("����"),PUNCT("��Ӣ�ı�����"),OTHR("��������");
	
	private String name;
	CharacterType(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
}
