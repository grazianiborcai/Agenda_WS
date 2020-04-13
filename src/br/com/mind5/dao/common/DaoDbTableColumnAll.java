package br.com.mind5.dao.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.business.address.dao.DaoAddressDbTableColumn;
import br.com.mind5.business.addressSearch.dao.DaoAddarchDbTableColumn;
import br.com.mind5.business.addressSnapshot.dao.AddresnapDbTableColumn;
import br.com.mind5.business.calendarDate.dao.CalateDbTableColumn;
import br.com.mind5.business.cart.dao.CartDbTableColumn;
import br.com.mind5.business.cartItem.dao.CartemDbTableColumn;
import br.com.mind5.business.cartItemSearch.dao.CartemarchDbTableColumn;
import br.com.mind5.business.cartReserve.dao.CarterveDbTableColumn;
import br.com.mind5.business.company.dao.CompDbTableColumn;
import br.com.mind5.business.companyConflict.dao.CompcoDbTableColumn;
import br.com.mind5.business.companyList.dao.ComplisDbTableColumn;
import br.com.mind5.business.companySearch.dao.ComparchDbTableColumn;
import br.com.mind5.business.companySnapshot.dao.CompnapDbTableColumn;
import br.com.mind5.business.customer.dao.CusDbTableColumn;
import br.com.mind5.business.customerList.dao.CuslisDbTableColumn;
import br.com.mind5.business.customerSearch.dao.CusarchDbTableColumn;
import br.com.mind5.business.customerSnapshot.dao.CusnapDbTableColumn;
import br.com.mind5.business.employee.dao.EmpDbTableColumn;
import br.com.mind5.business.employeeLeaveDate.dao.EmplateDbTableColumn;
import br.com.mind5.business.employeeLeaveDateRange.dao.EmplargDbTableColumn;
import br.com.mind5.business.employeeLeaveDateSearch.dao.EmplarchDbTableColumn;
import br.com.mind5.business.employeeList.dao.EmplisDbTableColumn;
import br.com.mind5.business.employeeMaterial.dao.EmpmatDbTableColumn;
import br.com.mind5.business.employeeMaterialSearch.dao.EmpmarchDbTableColumn;
import br.com.mind5.business.employeePosition.dao.EmposDbTableColumn;
import br.com.mind5.business.employeePositionSearch.dao.EmposarchDbTableColumn;
import br.com.mind5.business.employeeSearch.dao.EmparchDbTableColumn;
import br.com.mind5.business.employeeSnapshot.dao.EmpnapDbTableColumn;
import br.com.mind5.business.employeeWorkTime.dao.EmpwotmDbTableColumn;
import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeOutlier.dao.EmpwoutDbTableColumn;
import br.com.mind5.business.employeeWorkTimeRange.dao.EmpworgDbTableColumn;
import br.com.mind5.business.employeeWorkTimeSearch.dao.EmpwotarchDbTableColumn;
import br.com.mind5.business.feeDefault.dao.FeedefDbTableColumn;
import br.com.mind5.business.feeOwner.dao.FeewnerDbTableColumn;
import br.com.mind5.business.masterData.dao.MasterDataDbTableColumn;
import br.com.mind5.business.material.dao.MatDbTableColumn;
import br.com.mind5.business.materialList.dao.DaoMatlisDbTableColumn;
import br.com.mind5.business.materialMovement.dao.MatmovDbTableColumn;
import br.com.mind5.business.materialMovementSearch.dao.MatmarchDbTableColumn;
import br.com.mind5.business.materialSearch.dao.MatarchDbTableColumn;
import br.com.mind5.business.materialSnapshot.dao.MatsnapDbTableColumn;
import br.com.mind5.business.materialStock.dao.MatockDbTableColumn;
import br.com.mind5.business.materialStockSearch.dao.MatocarchDbTableColumn;
import br.com.mind5.business.materialStore.dao.MatoreDbTableColumn;
import br.com.mind5.business.materialStoreSearch.dao.MatorarchDbTableColumn;
import br.com.mind5.business.materialStoreSnapshot.dao.MatorapDbTableColumn;
import br.com.mind5.business.materialText.dao.MatextDbTableColumn;
import br.com.mind5.business.materialTextDefault.dao.MatextaultDbTableColumn;
import br.com.mind5.business.materialTextSearch.dao.MatextarchDbTableColumn;
import br.com.mind5.business.materialTextSnapshot.dao.MatextsnapDbTableColumn;
import br.com.mind5.business.moonCalendar.dao.MooncalDbTableColumn;
import br.com.mind5.business.order.dao.OrderDbTableColumn;
import br.com.mind5.business.orderItem.dao.OrderemDbTableColumn;
import br.com.mind5.business.orderItemSearch.dao.OrdemarchDbTableColumn;
import br.com.mind5.business.orderItemSnapshot.dao.OrdemrapDbTableColumn;
import br.com.mind5.business.orderList.dao.OrdistDbTableColumn;
import br.com.mind5.business.orderReserve.dao.OrderveDbTableColumn;
import br.com.mind5.business.orderSearch.dao.OrdarchDbTableColumn;
import br.com.mind5.business.orderSnapshot.dao.OrdnapDbTableColumn;
import br.com.mind5.business.owner.dao.DaoOwnerDbTableColumn;
import br.com.mind5.business.ownerList.dao.OwnelisDbTableColumn;
import br.com.mind5.business.ownerSnapshot.dao.OwnerapDbTableColumn;
import br.com.mind5.business.person.dao.PersonDbTableColumn;
import br.com.mind5.business.personList.dao.PersolisDbTableColumn;
import br.com.mind5.business.personSearch.dao.PerarchDbTableColumn;
import br.com.mind5.business.personSnapshot.dao.PersonapDbTableColumn;
import br.com.mind5.business.phone.dao.PhoneDbTableColumn;
import br.com.mind5.business.phoneSearch.dao.PhonarchDbTableColumn;
import br.com.mind5.business.phoneSnapshot.dao.PhonapDbTableColumn;
import br.com.mind5.business.planingData.dao.PlanataDbTableColumn;
import br.com.mind5.business.scheduleLine.dao.SchedineDbTableColumn;
import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.mind5.business.scheduleList.dao.SchedistDbTableColumn;
import br.com.mind5.business.scheduleMonthData.dao.SchedonthatDbTableColumn;
import br.com.mind5.business.scheduleMoviment.dao.SchedovmDbTableColumn;
import br.com.mind5.business.scheduleRange.dao.SchedageDbTableColumn;
import br.com.mind5.business.scheduleSearch.dao.SchedarchDbTableColumn;
import br.com.mind5.business.scheduleWeekData.dao.SchedeekdatDbTableColumn;
import br.com.mind5.business.scheduleYearData.dao.SchedyeratDbTableColumn;
import br.com.mind5.business.store.dao.StoreDbTableColumn;
import br.com.mind5.business.storeLeaveDate.dao.StolateDbTableColumn;
import br.com.mind5.business.storeLeaveDateRange.dao.StolargDbTableColumn;
import br.com.mind5.business.storeLeaveDateSearch.dao.StolarchDbTableColumn;
import br.com.mind5.business.storeList.dao.DaoStolisDbTableColumn;
import br.com.mind5.business.storeSearch.dao.SotarchDbTableColumn;
import br.com.mind5.business.storeSnapshot.dao.StorapDbTableColumn;
import br.com.mind5.business.storeWorkTime.dao.StowotmDbTableColumn;
import br.com.mind5.business.storeWorkTimeRange.dao.StoworgDbTableColumn;
import br.com.mind5.business.storeWorkTimeSearch.dao.StowotarchDbTableColumn;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumn;
import br.com.mind5.file.fileImage.dao.FimgDbTableColumn;
import br.com.mind5.file.fileImageList.dao.FimistDbTableColumn;
import br.com.mind5.file.fileImageSearch.dao.FimarchDbTableColumn;
import br.com.mind5.file.filePath.dao.FathDbTableColumn;
import br.com.mind5.form.formAddress.dao.DaoFormessDbTableColumn;
import br.com.mind5.form.formPhone.dao.DaoFormoneDbTableColumn;
import br.com.mind5.masterData.moonPhase.dao.MoonaseDbTableColumn;
import br.com.mind5.masterData.moonPhaseSearch.dao.MoonasarchDbTableColumn;
import br.com.mind5.masterData.state.dao.DaoStateDbTableColumn;
import br.com.mind5.masterData.stateSearch.dao.DaoStatarchDbTableColumn;
import br.com.mind5.message.email.dao.EmailDbTableColumn;
import br.com.mind5.message.emailBody.dao.EmabodyDbTableColumn;
import br.com.mind5.message.sysMessage.dao.SymsgDbTableColumn;
import br.com.mind5.payment.countryPartner.dao.CounparDbTableColumn;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchDbTableColumn;
import br.com.mind5.payment.creditCard.dao.CrecardDbTableColumn;
import br.com.mind5.payment.creditCardSearch.dao.CrecarchDbTableColumn;
import br.com.mind5.payment.customerPartner.dao.CusparDbTableColumn;
import br.com.mind5.payment.customerPartnerSearch.dao.CusparchDbTableColumn;
import br.com.mind5.payment.ownerPartner.dao.OwnparDbTableColumn;
import br.com.mind5.payment.payOrder.dao.PayordDbTableColumn;
import br.com.mind5.payment.payOrderItem.dao.PayordemDbTableColumn;
import br.com.mind5.payment.payOrderItemList.dao.PayordemistDbTableColumn;
import br.com.mind5.payment.payOrderItemSearch.dao.PayormarchDbTableColumn;
import br.com.mind5.payment.payOrderList.dao.PayordistDbTableColumn;
import br.com.mind5.payment.payOrderSearch.dao.PayordarchDbTableColumn;
import br.com.mind5.payment.setupPartner.dao.SetuparDbTableColumn;
import br.com.mind5.payment.storePartner.dao.StoparDbTableColumn;
import br.com.mind5.payment.storePartnerList.dao.StoplisDbTableColumn;
import br.com.mind5.payment.storePartnerSearch.dao.StoparchDbTableColumn;
import br.com.mind5.payment.storePartnerSnapshot.dao.StoparnapDbTableColumn;
import br.com.mind5.payment.systemPartner.dao.SysparDbTableColumn;
import br.com.mind5.payment.systemPartnerSearch.dao.SysparchDbTableColumn;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipDbTableColumn;
import br.com.mind5.security.storeAuthorization.dao.StorauthDbTableColumn;
import br.com.mind5.security.user.dao.UserDbTableColumn;
import br.com.mind5.security.userList.dao.UselisDbTableColumn;
import br.com.mind5.security.userPassword.dao.UpswdDbTableColumn;
import br.com.mind5.security.userSearch.dao.UserarchDbTableColumn;
import br.com.mind5.security.userSnapshot.dao.UserapDbTableColumn;
import br.com.mind5.security.username.dao.UsernameDbTableColumn;
import br.com.mind5.webhook.moipMultipayment.dao.WokaymoipDbTableColumn;
import br.com.mind5.webhook.moipRefund.dao.WokefumoipDbTableColumn;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	public static void initialize() {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDbTableColumn());
		addTable(new MatextDbTableColumn());
		addTable(new EmpmatDbTableColumn());
		addTable(new MatsnapDbTableColumn());
		addTable(new StoreDbTableColumn());
		addTable(new DaoStolisDbTableColumn());
		addTable(new EmposDbTableColumn());
		addTable(new MasterDataDbTableColumn());
		addTable(new StowotmDbTableColumn());
		addTable(new StolateDbTableColumn());
		addTable(new EmpwotmDbTableColumn());
		addTable(new EmplateDbTableColumn());
		addTable(new EmpwocoDbTableColumn());
		addTable(new EmpwoutDbTableColumn());
		addTable(new EmpDbTableColumn());
		addTable(new EmpnapDbTableColumn());
		addTable(new EmplisDbTableColumn());
		addTable(new CusDbTableColumn());
		addTable(new DaoOwnerDbTableColumn());
		addTable(new MatoreDbTableColumn());
		addTable(new CartDbTableColumn());
		addTable(new FeewnerDbTableColumn());
		addTable(new FeedefDbTableColumn());
		addTable(new CarterveDbTableColumn());
		addTable(new OrderemDbTableColumn());
		addTable(new OrderDbTableColumn());
		addTable(new DaoAddressDbTableColumn());
		addTable(new AddresnapDbTableColumn());
		addTable(new DaoFormessDbTableColumn());
		addTable(new PhoneDbTableColumn());
		addTable(new PhonapDbTableColumn());
		addTable(new DaoFormoneDbTableColumn());
		addTable(new PersonDbTableColumn());
		addTable(new PersolisDbTableColumn());
		addTable(new PersonapDbTableColumn());
		addTable(new UserDbTableColumn());
		addTable(new UserapDbTableColumn());
		addTable(new StoparDbTableColumn());
		addTable(new CounparDbTableColumn());
		addTable(new CompDbTableColumn());
		addTable(new UpswdDbTableColumn());
		addTable(new UsernameDbTableColumn());
		addTable(new MatmovDbTableColumn());
		addTable(new MatockDbTableColumn());
		addTable(new CusarchDbTableColumn());
		addTable(new PlanataDbTableColumn());
		addTable(new MatextsnapDbTableColumn());
		addTable(new CartemDbTableColumn());
		addTable(new OrderveDbTableColumn());
		addTable(new EmailDbTableColumn());
		addTable(new EmabodyDbTableColumn());
		addTable(new OwnparDbTableColumn());
		addTable(new StoparnapDbTableColumn());
		addTable(new SetuparDbTableColumn());
		addTable(new PayordDbTableColumn());
		addTable(new CusparDbTableColumn());
		addTable(new CrecardDbTableColumn());
		addTable(new SysparchDbTableColumn());
		addTable(new SysparDbTableColumn());
		addTable(new PayordemDbTableColumn());
		addTable(new PeresmoipDbTableColumn());
		addTable(new WokaymoipDbTableColumn());
		addTable(new WokefumoipDbTableColumn());
		addTable(new SchedineDbTableColumn());
		addTable(new StorapDbTableColumn());
		addTable(new CompnapDbTableColumn());
		addTable(new CusnapDbTableColumn());
		addTable(new CuslisDbTableColumn());
		addTable(new UselisDbTableColumn());
		addTable(new SchedinapDbTableColumn());
		addTable(new OrdarchDbTableColumn());
		addTable(new OrdistDbTableColumn());
		addTable(new SchedarchDbTableColumn());
		addTable(new OrdnapDbTableColumn());
		addTable(new OrdemrapDbTableColumn());
		addTable(new PayordarchDbTableColumn());
		addTable(new SchedistDbTableColumn());
		addTable(new SchedovmDbTableColumn());
		addTable(new SchedyeratDbTableColumn());
		addTable(new SchedonthatDbTableColumn());
		addTable(new SchedeekdatDbTableColumn());
		addTable(new FimgDbTableColumn());
		addTable(new FathDbTableColumn());
		addTable(new SymsgDbTableColumn());
		addTable(new OwnerapDbTableColumn());
		addTable(new ComplisDbTableColumn());
		addTable(new DaoAddarchDbTableColumn());
		addTable(new PhonarchDbTableColumn());
		addTable(new SotarchDbTableColumn());
		addTable(new ComparchDbTableColumn());
		addTable(new PerarchDbTableColumn());
		addTable(new FimarchDbTableColumn());
		addTable(new FimistDbTableColumn());
		addTable(new StorauthDbTableColumn());
		addTable(new StolarchDbTableColumn());
		addTable(new SchedageDbTableColumn());
		addTable(new StoplisDbTableColumn());
		addTable(new EmposarchDbTableColumn());
		addTable(new StoworgDbTableColumn());
		addTable(new StowotarchDbTableColumn());
		addTable(new EmpwotarchDbTableColumn());
		addTable(new EmplarchDbTableColumn());
		addTable(new EmparchDbTableColumn());
		addTable(new EmpmarchDbTableColumn());
		addTable(new MatextarchDbTableColumn());
		addTable(new MatextaultDbTableColumn());
		addTable(new DaoMatlisDbTableColumn());
		addTable(new MatarchDbTableColumn());
		addTable(new MatorarchDbTableColumn());
		addTable(new MatorapDbTableColumn());
		addTable(new MatocarchDbTableColumn());
		addTable(new MatmarchDbTableColumn());
		addTable(new UserarchDbTableColumn());
		addTable(new StoparchDbTableColumn());
		addTable(new CartemarchDbTableColumn());
		addTable(new EmpworgDbTableColumn());
		addTable(new EmplargDbTableColumn());
		addTable(new StolargDbTableColumn());
		addTable(new OrdemarchDbTableColumn());
		addTable(new CompcoDbTableColumn());
		addTable(new OwnelisDbTableColumn());
		addTable(new CusparchDbTableColumn());
		addTable(new CrecarchDbTableColumn());
		addTable(new CounparchDbTableColumn());
		addTable(new PayormarchDbTableColumn());
		addTable(new PayordistDbTableColumn());
		addTable(new PayordemistDbTableColumn());
		addTable(new MoonasarchDbTableColumn());
		addTable(new MoonaseDbTableColumn());
		addTable(new MooncalDbTableColumn());
		addTable(new CalateDbTableColumn());
		addTable(new DaoStateDbTableColumn());
		addTable(new DaoStatarchDbTableColumn());
	}
	
	
	
	private static void addTable(DaoDbTableColumn tblCol) {
		List<String> tblNames = tblCol.getTableNamesAsList();
		
		for (String eachTblName : tblNames) {
			List<DaoColumn> columns = tblCol.getTableColumnsAsList(eachTblName);
			tableColumns.put(eachTblName, columns);
		}
	}
	
	
	
	public static List<DaoColumn> getTableColumnsAsList(String tableName) {		
		List<DaoColumn> resultColumns = new ArrayList<>();
		List<DaoColumn> columns = getColumns(tableName);				
		
		for (DaoColumn eachColumn : columns) {
			DaoColumn copyColumn = makeClone(eachColumn);
			resultColumns.add(copyColumn);
		}
		
		return resultColumns;
	}
	
	
	
	private static List<DaoColumn> getColumns(String tableName) {
		List<DaoColumn> columns = tableColumns.get(tableName);
		
		
		if (columns == null) {
			logException(new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND));
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		}
		
		
		return columns;
	}
	
	
	
	private static DaoColumn makeClone(DaoColumn column) {
		try {
			return (DaoColumn) column.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private static void logException(Exception e) {
		SystemLog.logError(DaoDbTableColumnAll.class, e);
	}
}
