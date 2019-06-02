package br.com.gda.dao.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.address.dao.AddressDbTableColumn;
import br.com.gda.business.addressSnapshot.dao.AddresnapDbTableColumn;
import br.com.gda.business.cart.dao.CartDbTableColumn;
import br.com.gda.business.cartItem.dao.CartemDbTableColumn;
import br.com.gda.business.company.dao.CompDbTableColumn;
import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.customerSearch.dao.CusarchDbTableColumn;
import br.com.gda.business.employee.dao.EmpDbTableColumn;
import br.com.gda.business.employeeLeaveDate.dao.EmplevateDbTableColumn;
import br.com.gda.business.employeeList.dao.EmplisDbTableColumn;
import br.com.gda.business.employeeMaterial.dao.EmpmatDbTableColumn;
import br.com.gda.business.employeePosition.dao.EmposDbTableColumn;
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
import br.com.gda.business.owner.dao.OwnerDbTableColumn;
import br.com.gda.business.ownerStore.dao.OwntoreDbTableColumn;
import br.com.gda.business.person.dao.PersonDbTableColumn;
import br.com.gda.business.personCustomer.dao.PersonCusDbTableColumn;
import br.com.gda.business.personSnapshot.dao.PersonapDbTableColumn;
import br.com.gda.business.personUser_.dao.PersonUserDbTableColumn;
import br.com.gda.business.phone.dao.PhoneDbTableColumn;
import br.com.gda.business.phoneSnapshot.dao.PhonapDbTableColumn;
import br.com.gda.business.planingData.dao.PlanataDbTableColumn;
import br.com.gda.business.reserve.dao.ReserveDbTableColumn;
import br.com.gda.business.snapshot_.dao.SnapDbTableColumn;
import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeLeaveDate.dao.StolevateDbTableColumn;
import br.com.gda.business.storeList.dao.StolisDbTableColumn;
import br.com.gda.business.storeWorkTime.dao.StowotmDbTableColumn;
import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoDbTableColumn;
import br.com.gda.business.user.dao.UserDbTableColumn;
import br.com.gda.business.userSnapshot.dao.UserapDbTableColumn;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumn;
import br.com.gda.payService.payCustomer.dao.PaycusDbTableColumn;
import br.com.gda.payService.payPartnerCountry.dao.PayparCountryDbTableColumn;
import br.com.gda.payService.payPartnerStore.dao.PayparStoreDbTableColumn;
import br.com.gda.security.userPassword.dao.UpswdDbTableColumn;
import br.com.gda.security.username.dao.UsernameDbTableColumn;

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
		addTable(new EmplisDbTableColumn());
		addTable(new CusDbTableColumn());
		addTable(new OwnerDbTableColumn());
		addTable(new MatoreDbTableColumn());
		addTable(new CartDbTableColumn());
		addTable(new FeewnerDbTableColumn());
		addTable(new FeedefDbTableColumn());
		addTable(new ReserveDbTableColumn());
		addTable(new OrderemDbTableColumn());
		addTable(new OrderDbTableColumn());
		addTable(new AddressDbTableColumn());
		addTable(new AddresnapDbTableColumn());
		addTable(new FormAddressDbTableColumn());
		addTable(new PhoneDbTableColumn());
		addTable(new PhonapDbTableColumn());
		addTable(new FormPhoneDbTableColumn());
		addTable(new PersonDbTableColumn());
		addTable(new PersonapDbTableColumn());
		addTable(new UserDbTableColumn());
		addTable(new UserapDbTableColumn());
		addTable(new SnapDbTableColumn());
		addTable(new PersonUserDbTableColumn());	
		addTable(new PersonCusDbTableColumn());
		addTable(new PayparStoreDbTableColumn());
		addTable(new PayparCountryDbTableColumn());
		addTable(new PaycusDbTableColumn());
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
