package bench.test;

import bench.test.userfriendly;

public class runner {
	public static void main(String[] args) {
		userfriendly ruleaza = new userfriendly();
		((userfriendly) ruleaza).AWT();
		PCSpecs specs = new PCSpecs();
		specs.PCSpec();
		System.out.println(specs.hostname);
		System.out.println(specs.ipadress);
		System.out.println(specs.nameos);
		System.out.println(specs.ostype);
		System.out.println(specs.osversion);
		System.out.println(specs.proc1);
		System.out.println(specs.proc2);
		System.out.println(specs.proc3);
		System.out.println(specs.proc4);
		
		
	}
}