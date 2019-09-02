package br.com.gda.dao.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.address.dao.AddressDbTableColumn;
import br.com.gda.business.addressSnapshot.dao.AddresnapDbTableColumn;
import br.com.gda.business.cart.dao.CartDbTableColumn;
import br.com.gda.business.cartItem.dao.CartemDbTableColumn;
import br.com.gda.business.cartReserve.dao.CarterveDbTableColumn;
import br.com.gda.business.company.dao.CompDbTableColumn;
import br.com.gda.business.companySnapshot.dao.CompnapDbTableColumn;
import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.customerList.dao.CuslisDbTableColumn;
import br.com.gda.business.customerSearch.dao.CusarchDbTableColumn;
import br.com.gda.business.customerSnapshot.dao.CusnapDbTableColumn;
import br.com.gda.business.employee.dao.EmpDbTableColumn;
import br.com.gda.business.employeeLeaveDate.dao.EmplevateDbTableColumn;
import br.com.gda.business.employeeList.dao.EmplisDbTableColumn;
import br.com.gda.business.employeeMaterial.dao.EmpmatDbTableColumn;
import br.com.gda.business.employeePosition.dao.EmposDbTableColumn;
import br.com.gda.business.employeeSnapshot.dao.EmpnapDbTableColumn;
import br.com.gda.business.employeeWorkTime.dao.EmpwotmDbTableColumn;
import br.com.gda.business.employeeWorkTimeConflict.dao.EmpwocoDbTableColumn;
import br.com.gda.business.feeDefault.dao.FeedefDbTableColumn;
import br.com.gda.business.feeOwner.dao.FeewnerDbTableColumn;
import br.com.gda.business.form.formAddress.dao.FormAddressDbTableColumn;
import br.com.gda.business.form.formPhone.dao.FormPhoneDbTableColumn;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.business.material.dao.MatDbTableColumn;
import br.com.gda.business.materialMovement.dao.MatmovDbTableColumn;
import br.com.gda.business.materialSnapshot.dao.MatsnapDbTableColumn;
import br.com.gda.business.materialStock.dao.MatockDbTableColumn;
import br.com.gda.business.materialStore.dao.MatoreDbTableColumn;
import br.com.gda.business.materialText.dao.MatextDbTableColumn;
import br.com.gda.business.materialTextSnapshot.dao.MatextsnapDbTableColumn;
import br.com.gda.business.order.dao.OrderDbTableColumn;
import br.com.gda.business.orderItem.dao.OrderemDbTableColumn;
import br.com.gda.business.orderItemSnapshot.dao.OrdemrapDbTableColumn;
import br.com.gda.business.orderList.dao.OrdistDbTableColumn;
import br.com.gda.business.orderReserve.dao.OrderveDbTableColumn;
import br.com.gda.business.orderSearch.dao.OrdarchDbTableColumn;
import br.com.gda.business.orderSnapshot.dao.OrdnapDbTableColumn;
import br.com.gda.business.owner.dao.OwnerDbTableColumn;
import br.com.gda.business.ownerStore.dao.OwntoreDbTableColumn;
import br.com.gda.business.person.dao.PersonDbTableColumn;
import br.com.gda.business.personCustomer.dao.PersonCusDbTableColumn;
import br.com.gda.business.personList.dao.PersolisDbTableColumn;
import br.com.gda.business.personSnapshot.dao.PersonapDbTableColumn;
import br.com.gda.business.personUser_.dao.PersonUserDbTableColumn;
import br.com.gda.business.phone.dao.PhoneDbTableColumn;
import br.com.gda.business.phoneSnapshot.dao.PhonapDbTableColumn;
import br.com.gda.business.planingData.dao.PlanataDbTableColumn;
import br.com.gda.business.scheduleLine.dao.SchedineDbTableColumn;
import br.com.gda.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.gda.business.scheduleList.dao.SchedistDbTableColumn;
import br.com.gda.business.scheduleSearch.dao.SchedarchDbTableColumn;
import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeLeaveDate.dao.StolevateDbTableColumn;
import br.com.gda.business.storeList.dao.StolisDbTableColumn;
import br.com.gda.business.storeSnapshot.dao.StorapDbTableColumn;
import br.com.gda.business.storeWorkTime.dao.StowotmDbTableColumn;
import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoDbTableColumn;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumn;
import br.com.gda.message.email.dao.EmailDbTableColumn;
import br.com.gda.message.emailBody.dao.EmabodyDbTableColumn;
import br.com.gda.payment.countryPartner.dao.CounparDbTableColumn;
import br.com.gda.payment.creditCard.dao.CrecardDbTableColumn;
import br.com.gda.payment.customerPartner.dao.CusparDbTableColumn;
import br.com.gda.payment.ownerPartner.dao.OwnparDbTableColumn;
import br.com.gda.payment.partnerMoip.permissionMoip.dao.PeresmoipDbTableColumn;
import br.com.gda.payment.payOrder.dao.PayordDbTableColumn;
import br.com.gda.payment.payOrderItem.dao.PayordemDbTableColumn;
import br.com.gda.payment.payOrderSearch.dao.PayordarchDbTableColumn;
import br.com.gda.payment.setupPartner.dao.SetuparDbTableColumn;
import br.com.gda.payment.storePartner.dao.StoparDbTableColumn;
import br.com.gda.payment.storePartnerSnapshot.dao.StoparnapDbTableColumn;
import br.com.gda.payment.systemPartner.dao.SysparDbTableColumn;
import br.com.gda.security.user.dao.UserDbTableColumn;
import br.com.gda.security.userList.dao.UselistDbTableColumn;
import br.com.gda.security.userPassword.dao.UpswdDbTableColumn;
import br.com.gda.security.userSnapshot.dao.UserapDbTableColumn;
import br.com.gda.security.username.dao.UsernameDbTableColumn;
import br.com.gda.webhook.moipMultipayment.dao.WokaymoipDbTableColumn;
import br.com.gda.webhook.moipRefund.dao.WokefumoipDbTableColumn;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	
	static {
		buildTableColumns();
	}
	
	
	
	private static void buildTableColumns() {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDbTableColumn());
		addTable(new MatextDbTableColumn());
		addTable(new EmpmatDbTableColumn());
		addTable(new MatsnapDbTableColumn());
		addTable(new StoreDbTableColumn());
		addTable(new StolisDbTableColumn());
		addTable(new EmposDbTableColumn());
		addTable(new MasterDataDbTableColumn());
		addTable(new StowotmDbTableColumn());
		addTable(new StolevateDbTableColumn());
		addTable(new EmpwotmDbTableColumn());
		addTable(new EmplevateDbTableColumn());
		addTable(new EmpwocoDbTableColumn());
		addTable(new StoreCoDbTableColumn());
		addTable(new EmpDbTableColumn());
		addTable(new EmpnapDbTableColumn());
		addTable(new EmplisDbTableColumn());
		addTable(new CusDbTableColumn());
		addTable(new OwnerDbTableColumn());
		addTable(new MatoreDbTableColumn());
		addTable(new CartDbTableColumn());
		addTable(new FeewnerDbTableColumn());
		addTable(new FeedefDbTableColumn());
		addTable(new CarterveDbTableColumn());
		addTable(new OrderemDbTableColumn());
		addTable(new OrderDbTableColumn());
		addTable(new AddressDbTableColumn());
		addTable(new AddresnapDbTableColumn());
		addTable(new FormAddressDbTableColumn());
		addTable(new PhoneDbTableColumn());
		addTable(new PhonapDbTableColumn());
		addTable(new FormPhoneDbTableColumn());
		addTable(new PersonDbTableColumn());
		addTable(new PersolisDbTableColumn());
		addTable(new PersonapDbTableColumn());
		addTable(new UserDbTableColumn());
		addTable(new UserapDbTableColumn());
		addTable(new PersonUserDbTableColumn());	
		addTable(new PersonCusDbTableColumn());
		addTable(new StoparDbTableColumn());
		addTable(new CounparDbTableColumn());
		addTable(new CompDbTableColumn());
		addTable(new UpswdDbTableColumn());
		addTable(new OwntoreDbTableColumn());
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
		addTable(new UselistDbTableColumn());
		addTable(new SchedinapDbTableColumn());
		addTable(new OrdarchDbTableColumn());
		addTable(new OrdistDbTableColumn());
		addTable(new SchedarchDbTableColumn());
		addTable(new OrdnapDbTableColumn());
		addTable(new OrdemrapDbTableColumn());
		addTable(new PayordarchDbTableColumn());
		addTable(new SchedistDbTableColumn());
	}
	
	
	
	private static void addTable(DaoDbTableColumn tblCol) {
		List<String> tblNames = tblCol.getTableNamesAsList();
		
		for (String eachTblName : tblNames) {
			List<DaoColumn> columns = tblCol.getTableColumnsAsList(eachTblName);
			tableColumns.put(eachTblName, columns);
		}
	}
	
	
	
	public static List<DaoColumn> getTableColumnsAsList(String tableName) {
		List<DaoColumn> columns = tableColumns.get(tableName);
		
		if (columns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		
		List<DaoColumn> resultColumns = new ArrayList<>();
		
		for (DaoColumn eachColumn : columns) {
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
}
