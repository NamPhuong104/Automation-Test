package orangeHRM;

import org.testng.annotations.Test;

public class assignLeave extends generalFunction{

	@Test(enabled = false)
	public void TR_AL_01() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Goutam Ganesh");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("8");
		partialDay("All Days");
		duration("Specify Time");
		chooseSpcifyStartFromTime("10", "15","AM");
		chooseSpcifyStartToTime("11", "00", "AM");
		comments("TR_AL_01");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_02() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Odis Adalwin");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("Start Day Only");
		duration("Specify Time");
		chooseSpcifyStartFromTime("09", "00","AM");
		chooseSpcifyStartToTime("05", "00", "PM");
		comments("TR_AL_02");
		submit();
		checkResult("Successfully Saved");

	}
	@Test(enabled = false)
	public void TR_AL_03() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Lisa Andrews");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("End Day Only");
		duration("Specify Time");
		chooseSpcifyStartFromTime("09", "00","AM");
		chooseSpcifyStartToTime("05", "00", "PM");
		comments("TR_AL_03");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_04() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Jadine Jackie");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("Start and End Day");
		chooseStartDay("Specify Time");
		chooseSpcifyStartFromTime("09", "00","AM");
		chooseSpcifyStartToTime("10", "00", "AM");
		chooseEndDay("Specify Time");
		chooseSpcifyEndFromTime("01", "00","PM");
		chooseSpcifyEndToTime("02", "00","PM");
		comments("TR_AL_04");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_05() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Cecil Bonaparte");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("All Days");
		duration("Half Day - Morning");
		comments("TR_AL_05");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_06() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Odis  Adalwin");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("All Days");
		duration("Half Day - Afternoon");
		comments("TR_AL_06");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_07() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Chenzira  Chuki");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("Start Day Only");
		duration("Half Day - Morning");
		comments("TR_AL_07");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_08() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Dominic  Chase");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("Start Day Only");
		duration("Half Day - Afternoon");
		comments("TR_AL_08");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(enabled = false)
	public void TR_AL_09() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Cassidy  Hope");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("End Day Only");
		duration("Half Day - Morning");
		comments("TR_AL_09");
		submit();
		checkResult("Successfully Saved");

	}

	@Test(priority = 0)
	public void TR_AL_10() throws Exception  {
		login("admin", "admin123");
		selectModule("Leave");
		selectFunc("Assign Leave");
		findEmployeeName("Paul  Collings");
		selectLeaveType("CAN - Bereavement");
		selectFromDate("7");
		selectToDate("9");
		partialDay("End Day Only");
		duration("Half Day - Afternoon");
		comments("TR_AL_09");
		submit();
		checkResult("Successfully Saved");

	}
}
