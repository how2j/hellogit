package hellogit;

public class HelloGit {
	public static void main(String[] args) {
		System.out.println("Hello Git xxx");
		System.out.println("真的很感谢站长推出的这个网站，我是吴少");
		new hellogit.HelloGit().sayLove("meepo", 0.6);
	}
	
	public void sayLove(String name, double year) {
		if (year < 1)//year是找工作花的时间
		{
			System.out.println("我学的还行，找到了工作，爱你" + name);
		}
	}
}
