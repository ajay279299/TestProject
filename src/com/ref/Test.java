package com.ref;

public class Test {

	public static void main(String[] args) {
		
		
		try {
			invokeClassUsingReflectionWithoutCreatingNewInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		

		// new Thread(new Runnable() {
		// public void run() {
		// try {
		// System.out.println("First Thread Started");
		// invokeClassUsingReflectionWithoutCreatingNewInstance();
		// } catch (InstantiationException e) {
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// } catch (NoSuchFieldException e) {
		// e.printStackTrace();
		// }
		// }
		// }).start();

//		new Thread(new Runnable() {
//			public void run() {
//				try {
//					System.out.println("Second Thread Started");
//					invokeClassUsingReflectionWithoutCreatingNewInstance();
//				} catch (InstantiationException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (NoSuchFieldException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

	}

	private static void invokeClassUsingReflectionWithoutCreatingNewInstance()
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException {
		ReflectionManager.getInstance().getClassAtRuntimeUsingReflection(
				Issuer.class);
	}
}
