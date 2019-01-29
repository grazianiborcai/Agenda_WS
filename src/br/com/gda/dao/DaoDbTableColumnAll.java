package br.com.gda.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.address.dao.AddressDbTableColumn;
import br.com.gda.business.addressSnapshot.dao.AddressSnapDbTableColumn;
import br.com.gda.business.cart.dao.CartDbTableColumn;
import br.com.gda.business.cartSnapshot.dao.CartSnapDbTableColumn;
import br.com.gda.business.company.dao.CompDbTableColumn;
import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.employee.dao.EmpDbTableColumn;
import br.com.gda.business.employeeLeaveDate.dao.EmpLDateDbTableColumn;
import br.com.gda.business.employeeWorkTime.dao.EmpWTimeDbTableColumn;
import br.com.gda.business.employeeWorkTimeConflict.dao.EmpCoDbTableColumn;
import br.com.gda.business.feeDefault.dao.FeeDefaultDbTableColumn;
import br.com.gda.business.feeStore.dao.FeeStoreDbTableColumn;
import br.com.gda.business.form.formAddress.dao.FormAddressDbTableColumn;
import br.com.gda.business.form.formPhone.dao.FormPhoneDbTableColumn;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.business.material.dao.MatDbTableColumn;
import br.com.gda.business.materialEmployee.dao.MatEmpDbTableColumn;
import br.com.gda.business.materialSnapshot.dao.MatSnapDbTableColumn;
import br.com.gda.business.materialStore.dao.MatStoreDbTableColumn;
import br.com.gda.business.order.dao.OrderDbTableColumn;
import br.com.gda.business.owner.dao.OwnerDbTableColumn;
import br.com.gda.business.person.dao.PersonDbTableColumn;
import br.com.gda.business.personCustomer.dao.PersonCusDbTableColumn;
import br.com.gda.business.personSnapshot.dao.PersonSnapDbTableColumn;
import br.com.gda.business.personUser.dao.PersonUserDbTableColumn;
import br.com.gda.business.phone.dao.PhoneDbTableColumn;
import br.com.gda.business.phoneSnapshot.dao.PhoneSnapDbTableColumn;
import br.com.gda.business.reserve.dao.ReserveDbTableColumn;
import br.com.gda.business.snapshot.dao.SnapDbTableColumn;
import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeEmployee.dao.StoreEmpDbTableColumn;
import br.com.gda.business.storeLeaveDate.dao.StoreLDateDbTableColumn;
import br.com.gda.business.storeWorkTime.dao.StoreWTimeDbTableColumn;
import br.com.gda.business.storeWorkTimeConflict.dao.StoreCoDbTableColumn;
import br.com.gda.business.user.dao.UserDbTableColumn;
import br.com.gda.business.userSnapshot.dao.UserSnapDbTableColumn;
import br.com.gda.common.SystemMessage;
import br.com.gda.payService.payCustomer.dao.PaycusDbTableColumn;
import br.com.gda.payService.payPartnerCountry.dao.PayparCountryDbTableColumn;
import br.com.gda.payService.payPartnerStore.dao.PayparStoreDbTableColumn;
import br.com.gda.security.userPassword.dao.UpswdDbTableColumn;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	
	static {
		buildTableColumns();
	}
	
	
	
	private static void buildTableColumns() {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDbTableColumn());
		addTable(new MatEmpDbTableColumn());
		addTable(new MatSnapDbTableColumn());
		addTable(new StoreDbTableColumn());
		addTable(new StoreEmpDbTableColumn());
		addTable(new MasterDataDbTableColumn());
		addTable(new StoreWTimeDbTableColumn());
		addTable(new StoreLDateDbTableColumn());
		addTable(new EmpWTimeDbTableColumn());
		addTable(new EmpLDateDbTableColumn());
		addTable(new EmpCoDbTableColumn());
		addTable(new StoreCoDbTableColumn());
		addTable(new EmpDbTableColumn());
		addTable(new CusDbTableColumn());
		addTable(new OwnerDbTableColumn());
		addTable(new MatStoreDbTableColumn());
		addTable(new CartDbTableColumn());
		addTable(new CartSnapDbTableColumn());
		addTable(new FeeStoreDbTableColumn());
		addTable(new FeeDefaultDbTableColumn());
		addTable(new ReserveDbTableColumn());
		addTable(new OrderDbTableColumn());
		addTable(new AddressDbTableColumn());
		addTable(new AddressSnapDbTableColumn());
		addTable(new FormAddressDbTableColumn());
		addTable(new PhoneDbTableColumn());
		addTable(new PhoneSnapDbTableColumn());
		addTable(new FormPhoneDbTableColumn());
		addTable(new PersonDbTableColumn());
		addTable(new PersonSnapDbTableColumn());
		addTable(new UserDbTableColumn());
		addTable(new UserSnapDbTableColumn());
		addTable(new SnapDbTableColumn());
		addTable(new PersonUserDbTableColumn());	
		addTable(new PersonCusDbTableColumn());
		addTable(new PayparStoreDbTableColumn());
		addTable(new PayparCountryDbTableColumn());
		addTable(new PaycusDbTableColumn());
		addTable(new CompDbTableColumn());
		addTable(new UpswdDbTableColumn());
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
