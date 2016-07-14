package proxy;

import java.lang.reflect.Proxy;

public class ProxyTestMain {

	public Person getPersonProxy(Person person) {
		return (Person) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(),
				new TestInvocationHandler(person));
	}

	public void testPerson() {
		Person p = new PersonImpl("jason");
		Person pp = this.getPersonProxy(p);

		System.out.println(pp.getName());
		pp.setName("caroline");
		System.out.println(pp.getName());
	}

	public void testBook() {
		Book b = new BookImpl("YueMa");
		Book bp = (Book) Proxy.newProxyInstance(b.getClass().getClassLoader(),
				b.getClass().getInterfaces(), new TestInvocationHandler(b));

		System.out.println(bp.getAuther());
		bp.setAuther("Caro");
		System.out.println(bp.getAuther());
	}

	public static void main(String[] args) {
		ProxyTestMain test = new ProxyTestMain();
		test.testPerson();
		System.out.println("---------------");
		test.testBook();
	}

}
