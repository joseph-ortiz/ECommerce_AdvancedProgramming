package Logic;

import Models.User;

public class OrderTask implements Runnable{
	private User user;
	public OrderTask(User user)
	{
		this.user = user;
	}
	
	public void run()
	{
		System.out.println("user id: " +   user.getId() + " Started order");
		user.getOrders().get(0).placeOrder();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user id: " +   user.getId() + " Order placed for user");
		System.out.println("user id: " +   user.getId() + " Order Total: " + user.getOrders().get(0).getTotal());
	}
}