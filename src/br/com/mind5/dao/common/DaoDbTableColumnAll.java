package br.com.mind5.dao.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.business.address.dao.DaoAddressDbTableColumn;
import br.com.mind5.business.addressSearch.dao.DaoAddarchDbTableColumn;
import br.com.mind5.business.addressSnapshot.dao.DaoAddresnapDbTableColumn;
import br.com.mind5.business.calendarDate.dao.DaoCalateDbTableColumn;
import br.com.mind5.business.calendarDateSearch.dao.DaoCalatarchDbTableColumn;
import br.com.mind5.business.calendarMoon.dao.DaoMooncalDbTableColumn;
import br.com.mind5.business.calendarWeekYear.dao.DaoCaleekyDbTableColumn;
import br.com.mind5.business.cart.dao.DaoCartDbTableColumn;
import br.com.mind5.business.cartItem.dao.DaoCartemDbTableColumn;
import br.com.mind5.business.cartItemSearch.dao.DaoCartemarchDbTableColumn;
import br.com.mind5.business.cartReserve.dao.DaoCarterveDbTableColumn;
import br.com.mind5.business.company.dao.DaoCompDbTableColumn;
import br.com.mind5.business.companyConflict.dao.DaoCompcoDbTableColumn;
import br.com.mind5.business.companyList.dao.DaoComplisDbTableColumn;
import br.com.mind5.business.companySearch.dao.DaoComparchDbTableColumn;
import br.com.mind5.business.companySnapshot.dao.DaoCompnapDbTableColumn;
import br.com.mind5.business.customer.dao.DaoCusDbTableColumn;
import br.com.mind5.business.customerList.dao.DaoCuslisDbTableColumn;
import br.com.mind5.business.customerSearch.dao.DaoCusarchDbTableColumn;
import br.com.mind5.business.customerSnapshot.dao.DaoCusnapDbTableColumn;
import br.com.mind5.business.employee.dao.DaoEmpDbTableColumn;
import br.com.mind5.business.employeeLeaveDate.dao.DaoEmplateDbTableColumn;
import br.com.mind5.business.employeeLeaveDateRange.dao.DaoEmplargDbTableColumn;
import br.com.mind5.business.employeeLeaveDateSearch.dao.EmplarchDbTableColumn;
import br.com.mind5.business.employeeList.dao.EmplisDbTableColumn;
import br.com.mind5.business.employeeMaterial.dao.EmpmatDbTableColumn;
import br.com.mind5.business.employeeMaterialSearch.dao.EmpmarchDbTableColumn;
import br.com.mind5.business.employeePosition.dao.DaoEmposDbTableColumn;
import br.com.mind5.business.employeePositionSearch.dao.DaoEmposarchDbTableColumn;
import br.com.mind5.business.employeeSearch.dao.EmparchDbTableColumn;
import br.com.mind5.business.employeeSnapshot.dao.EmpnapDbTableColumn;
import br.com.mind5.business.employeeWorkTime.dao.EmpwotmDbTableColumn;
import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeOutlier.dao.EmpwoutDbTableColumn;
import br.com.mind5.business.employeeWorkTimeRange.dao.EmpworgDbTableColumn;
import br.com.mind5.business.employeeWorkTimeSearch.dao.DaoEmpwotarchDbTableColumn;
import br.com.mind5.business.feeDefault.dao.FeedefDbTableColumn;
import br.com.mind5.business.feeOwner.dao.FeewnerDbTableColumn;
import br.com.mind5.business.masterData.dao.MasterDataDbTableColumn;
import br.com.mind5.business.material.dao.MatDbTableColumn;
import br.com.mind5.business.materialList.dao.DaoMatlisDbTableColumn;
import br.com.mind5.business.materialMovement.dao.MatmovDbTableColumn;
import br.com.mind5.business.materialMovementSearch.dao.MatmarchDbTableColumn;
import br.com.mind5.business.materialSearch.dao.DaoMatarchDbTableColumn;
import br.com.mind5.business.materialSnapshot.dao.MatsnapDbTableColumn;
import br.com.mind5.business.materialStock.dao.MatockDbTableColumn;
import br.com.mind5.business.materialStockSearch.dao.MatocarchDbTableColumn;
import br.com.mind5.business.materialStore.dao.MatoreDbTableColumn;
import br.com.mind5.business.materialStoreSearch.dao.MatorarchDbTableColumn;
import br.com.mind5.business.materialStoreSnapshot.dao.MatorapDbTableColumn;
import br.com.mind5.business.materialText.dao.DaoMatextDbTableColumn;
import br.com.mind5.business.materialTextDefault.dao.DaoMatextaultDbTableColumn;
import br.com.mind5.business.materialTextSearch.dao.DaoMatextarchDbTableColumn;
import br.com.mind5.business.materialTextSnapshot.dao.MatextsnapDbTableColumn;
import br.com.mind5.business.notes.dao.DaoNotesDbTableColumn;
import br.com.mind5.business.order.dao.DaoOrderDbTableColumn;
import br.com.mind5.business.orderItem.dao.DaoOrderemDbTableColumn;
import br.com.mind5.business.orderItemList.dao.DaoOrdemistDbTableColumn;
import br.com.mind5.business.orderItemSearch.dao.DaoOrdemarchDbTableColumn;
import br.com.mind5.business.orderItemSnapshot.dao.DaoOrdemrapDbTableColumn;
import br.com.mind5.business.orderList.dao.DaoOrdistDbTableColumn;
import br.com.mind5.business.orderReserve.dao.DaoOrderveDbTableColumn;
import br.com.mind5.business.orderSearch.dao.DaoOrdarchDbTableColumn;
import br.com.mind5.business.orderSnapshot.dao.DaoOrdnapDbTableColumn;
import br.com.mind5.business.owner.dao.DaoOwnerDbTableColumn;
import br.com.mind5.business.ownerList.dao.DaoOwnelisDbTableColumn;
import br.com.mind5.business.ownerSearch.dao.DaoOwnarchDbTableColumn;
import br.com.mind5.business.ownerSnapshot.dao.OwnerapDbTableColumn;
import br.com.mind5.business.person.dao.DaoPersonDbTableColumn;
import br.com.mind5.business.personList.dao.DaoPersolisDbTableColumn;
import br.com.mind5.business.personSearch.dao.DaoPerarchDbTableColumn;
import br.com.mind5.business.personSnapshot.dao.PersonapDbTableColumn;
import br.com.mind5.business.phone.dao.DaoPhoneDbTableColumn;
import br.com.mind5.business.phoneSearch.dao.DaoPhonarchDbTableColumn;
import br.com.mind5.business.phoneSnapshot.dao.DaoPhonapDbTableColumn;
import br.com.mind5.business.planingData.dao.PlanataDbTableColumn;
import br.com.mind5.business.refundPolicyOwner.dao.DaoRefupownDbTableColumn;
import br.com.mind5.business.refundPolicyStore.dao.DaoRefuporeDbTableColumn;
import br.com.mind5.business.refundPolicyStoreSearch.dao.DaoRefuporarchDbTableColumn;
import br.com.mind5.business.scheduleAuthorization.dao.DaoSchedauthDbTableColumn;
import br.com.mind5.business.scheduleDayData.dao.DaoSchedaytaDbTableColumn;
import br.com.mind5.business.scheduleLine.dao.DaoSchedineDbTableColumn;
import br.com.mind5.business.scheduleLineSnapshot.dao.DaoSchedinapDbTableColumn;
import br.com.mind5.business.scheduleList.dao.SchedistDbTableColumn;
import br.com.mind5.business.scheduleMonthData.dao.DaoSchedonthatDbTableColumn;
import br.com.mind5.business.scheduleMoviment.dao.DaoSchedovmDbTableColumn;
import br.com.mind5.business.scheduleRange.dao.SchedageDbTableColumn;
import br.com.mind5.business.scheduleReserve.dao.DaoSchederveDbTableColumn;
import br.com.mind5.business.scheduleSearch.dao.DaoSchedarchDbTableColumn;
import br.com.mind5.business.scheduleWeekData.dao.DaoSchedeekdatDbTableColumn;
import br.com.mind5.business.scheduleYearData.dao.DaoSchedyeratDbTableColumn;
import br.com.mind5.business.store.dao.DaoStoreDbTableColumn;
import br.com.mind5.business.storeLeaveDate.dao.DaoStolateDbTableColumn;
import br.com.mind5.business.storeLeaveDateRange.dao.DaoStolargDbTableColumn;
import br.com.mind5.business.storeLeaveDateSearch.dao.DaoStolarchDbTableColumn;
import br.com.mind5.business.storeList.dao.DaoStolisDbTableColumn;
import br.com.mind5.business.storeNearby.dao.DaoStorbyDbTableColumn;
import br.com.mind5.business.storeProspect.dao.DaoStoprosDbTableColumn;
import br.com.mind5.business.storeProspectSearch.dao.DaoStoprarchDbTableColumn;
import br.com.mind5.business.storeSearch.dao.DaoSotarchDbTableColumn;
import br.com.mind5.business.storeSnapshot.dao.DaoStorapDbTableColumn;
import br.com.mind5.business.storeWorkTime.dao.StowotmDbTableColumn;
import br.com.mind5.business.storeWorkTimeRange.dao.StoworgDbTableColumn;
import br.com.mind5.business.storeWorkTimeSearch.dao.DaoStowotarchDbTableColumn;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.config.sysOwnerSignup.dao.DaoSysonupDbTableColumn;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumn;
import br.com.mind5.file.fileImage.dao.DaoFimgDbTableColumn;
import br.com.mind5.file.fileImageList.dao.DaoFimistDbTableColumn;
import br.com.mind5.file.fileImageSearch.dao.DaoFimarchDbTableColumn;
import br.com.mind5.file.filePath.dao.FathDbTableColumn;
import br.com.mind5.form.formAddress.dao.DaoFormessDbTableColumn;
import br.com.mind5.form.formPhone.dao.DaoFormoneDbTableColumn;
import br.com.mind5.masterData.areaPhone.dao.DaoAreaneDbTableColumn;
import br.com.mind5.masterData.areaPhoneSearch.dao.DaoAreanarchDbTableColumn;
import br.com.mind5.masterData.authorizationGroup.dao.DaoAuthgroupDbTableColumn;
import br.com.mind5.masterData.authorizationGroupRole.dao.DaoAuthgroleDbTableColumn;
import br.com.mind5.masterData.businessArea.dao.DaoBusareaDbTableColumn;
import br.com.mind5.masterData.businessAreaSearch.dao.DaoBusarearchDbTableColumn;
import br.com.mind5.masterData.country.dao.DaoCountryDbTableColumn;
import br.com.mind5.masterData.countryPhone.dao.DaoCountroneDbTableColumn;
import br.com.mind5.masterData.countryPhoneSearch.dao.DaoCountronarchDbTableColumn;
import br.com.mind5.masterData.countrySearch.dao.DaoCountarchDbTableColumn;
import br.com.mind5.masterData.currency.dao.DaoCurrencyDbTableColumn;
import br.com.mind5.masterData.currencySearch.dao.DaoCurrarshDbTableColumn;
import br.com.mind5.masterData.dayParting.dao.DaoDaypartDbTableColumn;
import br.com.mind5.masterData.dayPartingSearch.dao.DaoDayparchDbTableColumn;
import br.com.mind5.masterData.entityCategory.dao.DaoEntitegDbTableColumn;
import br.com.mind5.masterData.feeCategory.dao.DaoFeecatDbTableColumn;
import br.com.mind5.masterData.feeCategorySearch.dao.DaoFeecatarchDbTableColumn;
import br.com.mind5.masterData.fileDocType.dao.DaoFidoceDbTableColumn;
import br.com.mind5.masterData.fileDocTypeSearch.dao.DaoFidocarchDbTableColumn;
import br.com.mind5.masterData.gender.dao.DaoGenderDbTableColumn;
import br.com.mind5.masterData.genderSearch.dao.DaoGendarchDbTableColumn;
import br.com.mind5.masterData.language.dao.DaoLanguDbTableColumn;
import br.com.mind5.masterData.languageSearch.dao.DaoLangarchDbTableColumn;
import br.com.mind5.masterData.materialCategory.dao.DaoMategDbTableColumn;
import br.com.mind5.masterData.materialCategorySearch.dao.DaoMategarchDbTableColumn;
import br.com.mind5.masterData.materialGroup.dao.DaoMatoupDbTableColumn;
import br.com.mind5.masterData.materialGroupSearch.dao.DaoMatouparchDbTableColumn;
import br.com.mind5.masterData.materialType.dao.DaoMatypeDbTableColumn;
import br.com.mind5.masterData.materialTypeSearch.dao.DaoMatyparchDbTableColumn;
import br.com.mind5.masterData.materialUnit.dao.DaoMatunitDbTableColumn;
import br.com.mind5.masterData.materialUnitSearch.dao.DaoMatunitarchDbTableColumn;
import br.com.mind5.masterData.month.dao.DaoMonthDbTableColumn;
import br.com.mind5.masterData.monthSearch.dao.DaoMontharchDbTableColumn;
import br.com.mind5.masterData.moonPhase.dao.DaoMoonaseDbTableColumn;
import br.com.mind5.masterData.moonPhaseSearch.dao.DaoMoonasarchDbTableColumn;
import br.com.mind5.masterData.movimentType.dao.DaoMamovypeDbTableColumn;
import br.com.mind5.masterData.orderStatus.dao.DaoOrderatusDbTableColumn;
import br.com.mind5.masterData.orderStatusSearch.dao.DaoOrderatarchDbTableColumn;
import br.com.mind5.masterData.paymentPartner.dao.DaoPayparDbTableColumn;
import br.com.mind5.masterData.paymentStatus.dao.DaoPaymenusDbTableColumn;
import br.com.mind5.masterData.paymentStatusSearch.dao.DaoPaymenusarchDbTableColumn;
import br.com.mind5.masterData.position.dao.DaoPositionDbTableColumn;
import br.com.mind5.masterData.prospectStatus.dao.DaoProstusDbTableColumn;
import br.com.mind5.masterData.prospectStatusSearch.dao.DaoProstarchDbTableColumn;
import br.com.mind5.masterData.refundPolicy.dao.DaoRefupoDbTableColumn;
import br.com.mind5.masterData.refundPolicyGroup.dao.DaoRefugroupDbTableColumn;
import br.com.mind5.masterData.refundPolicyGroupItem.dao.DaoRefugritemDbTableColumn;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.dao.DaoRefugritarchDbTableColumn;
import br.com.mind5.masterData.refundPolicyGroupSearch.dao.DaoRefugrarchDbTableColumn;
import br.com.mind5.masterData.scheduleStatus.dao.DaoSchedatusDbTableColumn;
import br.com.mind5.masterData.state.dao.DaoStateDbTableColumn;
import br.com.mind5.masterData.stateSearch.dao.DaoStatarchDbTableColumn;
import br.com.mind5.masterData.sysEnvironment.dao.DaoSysenvDbTableColumn;
import br.com.mind5.masterData.timezone.dao.DaoTimezoneDbTableColumn;
import br.com.mind5.masterData.timezoneSearch.dao.DaoTimezonarchDbTableColumn;
import br.com.mind5.masterData.userCategory.dao.DaoUseregDbTableColumn;
import br.com.mind5.masterData.weekday.dao.DaoWeekdayDbTableColumn;
import br.com.mind5.masterData.weekdaySearch.dao.DaoWeekdarchDbTableColumn;
import br.com.mind5.message.email.dao.DaoEmailDbTableColumn;
import br.com.mind5.message.emailBody.dao.DaoEmabodyDbTableColumn;
import br.com.mind5.message.sysMessage.dao.DaoSymsgDbTableColumn;
import br.com.mind5.payment.countryPartner.dao.CounparDbTableColumn;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchDbTableColumn;
import br.com.mind5.payment.creditCard.dao.DaoCrecardDbTableColumn;
import br.com.mind5.payment.creditCardSearch.dao.CrecarchDbTableColumn;
import br.com.mind5.payment.customerPartner.dao.DaoCusparDbTableColumn;
import br.com.mind5.payment.customerPartnerSearch.dao.DaoCusparchDbTableColumn;
import br.com.mind5.payment.ownerPartner.dao.OwnparDbTableColumn;
import br.com.mind5.payment.payOrder.dao.DaoPayordDbTableColumn;
import br.com.mind5.payment.payOrderItem.dao.DaoPayordemDbTableColumn;
import br.com.mind5.payment.payOrderItemList.dao.PayordemistDbTableColumn;
import br.com.mind5.payment.payOrderItemSearch.dao.DaoPayormarchDbTableColumn;
import br.com.mind5.payment.payOrderList.dao.PayordistDbTableColumn;
import br.com.mind5.payment.payOrderSearch.dao.DaoPayordarchDbTableColumn;
import br.com.mind5.payment.setupPartner.dao.DaoSetuparDbTableColumn;
import br.com.mind5.payment.storePartner.dao.StoparDbTableColumn;
import br.com.mind5.payment.storePartnerList.dao.DaoStoplisDbTableColumn;
import br.com.mind5.payment.storePartnerSearch.dao.DaoStoparchDbTableColumn;
import br.com.mind5.payment.storePartnerSnapshot.dao.StoparnapDbTableColumn;
import br.com.mind5.payment.systemPartner.dao.SysparDbTableColumn;
import br.com.mind5.payment.systemPartnerSearch.dao.SysparchDbTableColumn;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipDbTableColumn;
import br.com.mind5.security.otpProspectStore.dao.DaoOtporeDbTableColumn;
import br.com.mind5.security.otpUserPassword.dao.DaoOtperasDbTableColumn;
import br.com.mind5.security.storeAuthorization.dao.DaoStorauthDbTableColumn;
import br.com.mind5.security.user.dao.DaoUserDbTableColumn;
import br.com.mind5.security.userList.dao.DaoUselisDbTableColumn;
import br.com.mind5.security.userPassword.dao.DaoUpswdDbTableColumn;
import br.com.mind5.security.userSearch.dao.DaoUserarchDbTableColumn;
import br.com.mind5.security.userSnapshot.dao.UserapDbTableColumn;
import br.com.mind5.security.username.dao.DaoUsernameDbTableColumn;
import br.com.mind5.webhook.moipMultipayment.dao.DaoWokaymoipDbTableColumn;
import br.com.mind5.webhook.moipRefund.dao.DaoWokefumoipDbTableColumn;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	static {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDbTableColumn());
		addTable(new DaoMatextDbTableColumn());
		addTable(new EmpmatDbTableColumn());
		addTable(new MatsnapDbTableColumn());
		addTable(new DaoStoreDbTableColumn());
		addTable(new DaoStolisDbTableColumn());
		addTable(new DaoEmposDbTableColumn());
		addTable(new MasterDataDbTableColumn());
		addTable(new StowotmDbTableColumn());
		addTable(new DaoStolateDbTableColumn());
		addTable(new EmpwotmDbTableColumn());
		addTable(new DaoEmplateDbTableColumn());
		addTable(new EmpwocoDbTableColumn());
		addTable(new EmpwoutDbTableColumn());
		addTable(new DaoEmpDbTableColumn());
		addTable(new EmpnapDbTableColumn());
		addTable(new EmplisDbTableColumn());
		addTable(new DaoCusDbTableColumn());
		addTable(new DaoOwnerDbTableColumn());
		addTable(new MatoreDbTableColumn());
		addTable(new DaoCartDbTableColumn());
		addTable(new FeewnerDbTableColumn());
		addTable(new FeedefDbTableColumn());
		addTable(new DaoCarterveDbTableColumn());
		addTable(new DaoOrderemDbTableColumn());
		addTable(new DaoOrderDbTableColumn());
		addTable(new DaoAddressDbTableColumn());
		addTable(new DaoAddresnapDbTableColumn());
		addTable(new DaoFormessDbTableColumn());
		addTable(new DaoPhoneDbTableColumn());
		addTable(new DaoPhonapDbTableColumn());
		addTable(new DaoFormoneDbTableColumn());
		addTable(new DaoPersonDbTableColumn());
		addTable(new DaoPersolisDbTableColumn());
		addTable(new PersonapDbTableColumn());
		addTable(new DaoUserDbTableColumn());
		addTable(new UserapDbTableColumn());
		addTable(new StoparDbTableColumn());
		addTable(new CounparDbTableColumn());
		addTable(new DaoCompDbTableColumn());
		addTable(new DaoUpswdDbTableColumn());
		addTable(new DaoUsernameDbTableColumn());
		addTable(new MatmovDbTableColumn());
		addTable(new MatockDbTableColumn());
		addTable(new DaoCusarchDbTableColumn());
		addTable(new PlanataDbTableColumn());
		addTable(new MatextsnapDbTableColumn());
		addTable(new DaoCartemDbTableColumn());
		addTable(new DaoOrderveDbTableColumn());
		addTable(new DaoEmailDbTableColumn());
		addTable(new DaoEmabodyDbTableColumn());
		addTable(new OwnparDbTableColumn());
		addTable(new StoparnapDbTableColumn());
		addTable(new DaoSetuparDbTableColumn());
		addTable(new DaoPayordDbTableColumn());
		addTable(new DaoCusparDbTableColumn());
		addTable(new DaoCrecardDbTableColumn());
		addTable(new SysparchDbTableColumn());
		addTable(new SysparDbTableColumn());
		addTable(new DaoPayordemDbTableColumn());
		addTable(new PeresmoipDbTableColumn());
		addTable(new DaoWokaymoipDbTableColumn());
		addTable(new DaoWokefumoipDbTableColumn());
		addTable(new DaoSchedineDbTableColumn());
		addTable(new DaoStorapDbTableColumn());
		addTable(new DaoCompnapDbTableColumn());
		addTable(new DaoCusnapDbTableColumn());
		addTable(new DaoCuslisDbTableColumn());
		addTable(new DaoUselisDbTableColumn());
		addTable(new DaoSchedinapDbTableColumn());
		addTable(new DaoOrdarchDbTableColumn());
		addTable(new DaoOrdistDbTableColumn());
		addTable(new DaoSchedarchDbTableColumn());
		addTable(new DaoOrdnapDbTableColumn());
		addTable(new DaoOrdemrapDbTableColumn());
		addTable(new DaoPayordarchDbTableColumn());
		addTable(new SchedistDbTableColumn());
		addTable(new DaoSchedovmDbTableColumn());
		addTable(new DaoSchedyeratDbTableColumn());
		addTable(new DaoSchedonthatDbTableColumn());
		addTable(new DaoSchedeekdatDbTableColumn());
		addTable(new DaoFimgDbTableColumn());
		addTable(new FathDbTableColumn());
		addTable(new DaoSymsgDbTableColumn());
		addTable(new OwnerapDbTableColumn());
		addTable(new DaoComplisDbTableColumn());
		addTable(new DaoAddarchDbTableColumn());
		addTable(new DaoPhonarchDbTableColumn());
		addTable(new DaoSotarchDbTableColumn());
		addTable(new DaoComparchDbTableColumn());
		addTable(new DaoPerarchDbTableColumn());
		addTable(new DaoFimarchDbTableColumn());
		addTable(new DaoFimistDbTableColumn());
		addTable(new DaoStorauthDbTableColumn());
		addTable(new DaoStolarchDbTableColumn());
		addTable(new SchedageDbTableColumn());
		addTable(new DaoStoplisDbTableColumn());
		addTable(new DaoEmposarchDbTableColumn());
		addTable(new StoworgDbTableColumn());
		addTable(new DaoStowotarchDbTableColumn());
		addTable(new DaoEmpwotarchDbTableColumn());
		addTable(new EmplarchDbTableColumn());
		addTable(new EmparchDbTableColumn());
		addTable(new EmpmarchDbTableColumn());
		addTable(new DaoMatextarchDbTableColumn());
		addTable(new DaoMatextaultDbTableColumn());
		addTable(new DaoMatlisDbTableColumn());
		addTable(new DaoMatarchDbTableColumn());
		addTable(new MatorarchDbTableColumn());
		addTable(new MatorapDbTableColumn());
		addTable(new MatocarchDbTableColumn());
		addTable(new MatmarchDbTableColumn());
		addTable(new DaoUserarchDbTableColumn());
		addTable(new DaoStoparchDbTableColumn());
		addTable(new DaoCartemarchDbTableColumn());
		addTable(new EmpworgDbTableColumn());
		addTable(new DaoEmplargDbTableColumn());
		addTable(new DaoStolargDbTableColumn());
		addTable(new DaoOrdemarchDbTableColumn());
		addTable(new DaoCompcoDbTableColumn());
		addTable(new DaoOwnelisDbTableColumn());
		addTable(new DaoCusparchDbTableColumn());
		addTable(new CrecarchDbTableColumn());
		addTable(new CounparchDbTableColumn());
		addTable(new DaoPayormarchDbTableColumn());
		addTable(new PayordistDbTableColumn());
		addTable(new PayordemistDbTableColumn());
		addTable(new DaoMoonasarchDbTableColumn());
		addTable(new DaoMoonaseDbTableColumn());
		addTable(new DaoMooncalDbTableColumn());
		addTable(new DaoCalateDbTableColumn());
		addTable(new DaoStateDbTableColumn());
		addTable(new DaoStatarchDbTableColumn());
		addTable(new DaoLanguDbTableColumn());
		addTable(new DaoLangarchDbTableColumn());
		addTable(new DaoCurrencyDbTableColumn());
		addTable(new DaoCurrarshDbTableColumn());
		addTable(new DaoTimezoneDbTableColumn());
		addTable(new DaoTimezonarchDbTableColumn());
		addTable(new DaoCountroneDbTableColumn());
		addTable(new DaoCountronarchDbTableColumn());
		addTable(new DaoAreaneDbTableColumn());
		addTable(new DaoAreanarchDbTableColumn());
		addTable(new DaoCountryDbTableColumn());
		addTable(new DaoCountarchDbTableColumn());
		addTable(new DaoAuthgroleDbTableColumn());
		addTable(new DaoMategDbTableColumn());
		addTable(new DaoMategarchDbTableColumn());
		addTable(new DaoMatypeDbTableColumn());
		addTable(new DaoMatyparchDbTableColumn());
		addTable(new DaoMatunitDbTableColumn());
		addTable(new DaoMatunitarchDbTableColumn());
		addTable(new DaoBusareaDbTableColumn());
		addTable(new DaoBusarearchDbTableColumn());
		addTable(new DaoMatoupDbTableColumn());
		addTable(new DaoMatouparchDbTableColumn());
		addTable(new DaoGenderDbTableColumn());
		addTable(new DaoGendarchDbTableColumn());
		addTable(new DaoWeekdayDbTableColumn());
		addTable(new DaoWeekdarchDbTableColumn());
		addTable(new DaoDaypartDbTableColumn());
		addTable(new DaoDayparchDbTableColumn());
		addTable(new DaoOrderatusDbTableColumn());
		addTable(new DaoOrderatarchDbTableColumn());
		addTable(new DaoFeecatDbTableColumn());
		addTable(new DaoFeecatarchDbTableColumn());
		addTable(new DaoRefupoDbTableColumn());
		addTable(new DaoRefupownDbTableColumn());
		addTable(new DaoRefuporeDbTableColumn());
		addTable(new DaoRefugroupDbTableColumn());
		addTable(new DaoRefugritemDbTableColumn());
		addTable(new DaoRefugritarchDbTableColumn());
		addTable(new DaoPaymenusDbTableColumn());
		addTable(new DaoPaymenusarchDbTableColumn());
		addTable(new DaoOrdemistDbTableColumn());
		addTable(new DaoSchederveDbTableColumn());
		addTable(new DaoRefugrarchDbTableColumn());
		addTable(new DaoRefuporarchDbTableColumn());
		addTable(new DaoAuthgroupDbTableColumn());
		addTable(new DaoPayparDbTableColumn());
		addTable(new DaoSysenvDbTableColumn());
		addTable(new DaoUseregDbTableColumn());
		addTable(new DaoEntitegDbTableColumn());
		addTable(new DaoPositionDbTableColumn());
		addTable(new DaoMamovypeDbTableColumn());
		addTable(new DaoSchedaytaDbTableColumn());
		addTable(new DaoSchedatusDbTableColumn());
		addTable(new DaoMonthDbTableColumn());
		addTable(new DaoCalatarchDbTableColumn());
		addTable(new DaoMontharchDbTableColumn());
		addTable(new DaoCaleekyDbTableColumn());
		addTable(new DaoSysonupDbTableColumn());
		addTable(new DaoOwnarchDbTableColumn());
		addTable(new DaoFidoceDbTableColumn());
		addTable(new DaoFidocarchDbTableColumn());
		addTable(new DaoOtporeDbTableColumn());
		addTable(new DaoStoprosDbTableColumn());
		addTable(new DaoProstusDbTableColumn());
		addTable(new DaoProstarchDbTableColumn());
		addTable(new DaoStoprarchDbTableColumn());
		addTable(new DaoOtperasDbTableColumn());
		addTable(new DaoSchedauthDbTableColumn());
		addTable(new DaoStorbyDbTableColumn());
		addTable(new DaoNotesDbTableColumn());
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
	
	
	/*
	public static void clear() {
		if (tableColumns == null)
			return;
		
		tableColumns.clear();
		tableColumns = null;
	}
	*/
	
	
	private static void logException(Exception e) {
		SystemLog.logError(DaoDbTableColumnAll.class, e);
	}
}
