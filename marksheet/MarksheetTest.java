package com.rays.marksheet;

public class MarksheetTest {

	public static void main(String[] args) throws Exception {

		/*
		 * // Insert MarksheetBean bean = new MarksheetBean();
		 * 
		 * bean.setId(3); bean.setRollno("102"); bean.setFirstname("ayush");
		 * bean.setLastname("sisodiya"); bean.setPhy(65); bean.setChe(69);
		 * bean.setMath(85);
		 * 
		 * 
		 * MarksheetModel m = new MarksheetModel (); m.add(bean);
		 */

		// update
		/*
		 * MarksheetBean bean = new MarksheetBean(); bean.setFirstname("subham");
		 * bean.setLastname("solanki"); bean.setId(1);
		 * 
		 * MarksheetModel m = new MarksheetModel(); m.update(bean);
		 * 
		 */

		// delete
		/*
		 * MarksheetBean bean = new MarksheetBean(); bean.setId(15);
		 * 
		 * MarksheetModel m = new MarksheetModel(); m.delete(bean);
		 * 
		 */

		/*
		 * MarksheetBean bean = new MarksheetBean();
		 * 
		 * 
		 * MarksheetModel m = new MarksheetModel(); m.select(bean);
		 * 
		 */

		/*
		 * // Meritlist MarksheetBean bean = new MarksheetBean();
		 * 
		 * MarksheetModel m = new MarksheetModel(); m.meritlist(bean); ;
		 */

		// search

		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("101");

		MarksheetModel m = new MarksheetModel();
		m.search(bean);

	}
}
