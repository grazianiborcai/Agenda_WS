package br.com.mind5.dao.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.dao.SchedauthDaoDbTableColumn;
import br.com.mind5.authorization.storeAuthorization.dao.StorauthDaoDbTableColumn;
import br.com.mind5.business.address.dao.AddressDaoDbTableColumn;
import br.com.mind5.business.addressDefault.dao.AddaultDaoDbTableColumn;
import br.com.mind5.business.addressSearch.dao.AddarchDaoDbTableColumn;
import br.com.mind5.business.addressSnapshot.dao.AddresnapDaoDbTableColumn;
import br.com.mind5.business.addressSnapshotSearch.dao.AddresnaparchDaoDbTableColumn;
import br.com.mind5.business.calendarDate.dao.CalateDaoDbTableColumn;
import br.com.mind5.business.calendarDateSearch.dao.CalatarchDaoDbTableColumn;
import br.com.mind5.business.calendarMonth.dao.CalonthDaoDbTableColumn;
import br.com.mind5.business.calendarMonthSearch.dao.CalontharchDaoDbTableColumn;
import br.com.mind5.business.calendarMoon.dao.MooncalDaoDbTableColumn;
import br.com.mind5.business.calendarWeekYear.dao.CaleekyDaoDbTableColumn;
import br.com.mind5.business.cart.dao.CartDaoDbTableColumn;
import br.com.mind5.business.cartItem.dao.CartemDaoDbTableColumn;
import br.com.mind5.business.cartItemSearch.dao.CartemarchDaoDbTableColumn;
import br.com.mind5.business.cartReserve.dao.CarterveDaoDbTableColumn;
import br.com.mind5.business.company.dao.CompDaoDbTableColumn;
import br.com.mind5.business.companyConflict.dao.CompcoDaoDbTableColumn;
import br.com.mind5.business.companyList.dao.ComplisDaoDbTableColumn;
import br.com.mind5.business.companySearch.dao.ComparchDaoDbTableColumn;
import br.com.mind5.business.companySnapshot.dao.CompnapDaoDbTableColumn;
import br.com.mind5.business.customer.dao.CusDaoDbTableColumn;
import br.com.mind5.business.customerList.dao.CuslisDaoDbTableColumn;
import br.com.mind5.business.customerSearch.dao.CusarchDaoDbTableColumn;
import br.com.mind5.business.customerSnapshot.dao.CusnapDaoDbTableColumn;
import br.com.mind5.business.employee.dao.EmpDaoDbTableColumn;
import br.com.mind5.business.employeeLeaveDate.dao.EmplateDaoDbTableColumn;
import br.com.mind5.business.employeeLeaveDateRange.dao.EmplargDaoDbTableColumn;
import br.com.mind5.business.employeeLeaveDateSearch.dao.EmplarchDaoDbTableColumn;
import br.com.mind5.business.employeeList.dao.EmplisDaoDbTableColumn;
import br.com.mind5.business.employeeLunchTime.dao.EmplutmDaoDbTableColumn;
import br.com.mind5.business.employeeLunchTimeRange.dao.EmpulranDaoDbTableColumn;
import br.com.mind5.business.employeeLunchTimeSearch.dao.EmplutmarchDaoDbTableColumn;
import br.com.mind5.business.employeeLunchTimeSnapshot.dao.EmplutmapDaoDbTableColumn;
import br.com.mind5.business.employeeMaterial.dao.EmpmatDaoDbTableColumn;
import br.com.mind5.business.employeeMaterialSearch.dao.EmpmarchDaoDbTableColumn;
import br.com.mind5.business.employeePosition.dao.EmposDaoDbTableColumn;
import br.com.mind5.business.employeePositionSearch.dao.EmposarchDaoDbTableColumn;
import br.com.mind5.business.employeeSearch.dao.EmparchDaoDbTableColumn;
import br.com.mind5.business.employeeSnapshot.dao.EmpnapDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTime.dao.EmpwotmDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeConflict.dao.EmpwocoDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeOutlier.dao.EmpwoutDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeRange.dao.EmpworgDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeSearch.dao.EmpwotarchDaoDbTableColumn;
import br.com.mind5.business.employeeWorkTimeSnapshot.dao.EmpwotmapDaoDbTableColumn;
import br.com.mind5.business.feeDefault.dao.FeedefDaoDbTableColumn;
import br.com.mind5.business.feeOwner.dao.FeewnerDaoDbTableColumn;
import br.com.mind5.business.material.dao.MatDaoDbTableColumn;
import br.com.mind5.business.materialList.dao.MatlisDaoDbTableColumn;
import br.com.mind5.business.materialMovement.dao.MatmovDaoDbTableColumn;
import br.com.mind5.business.materialMovementSearch.dao.MatmarchDaoDbTableColumn;
import br.com.mind5.business.materialSearch.dao.MatarchDaoDbTableColumn;
import br.com.mind5.business.materialSnapshot.dao.MatsnapDaoDbTableColumn;
import br.com.mind5.business.materialStock.dao.MatockDaoDbTableColumn;
import br.com.mind5.business.materialStockSearch.dao.MatocarchDaoDbTableColumn;
import br.com.mind5.business.materialStore.dao.MatoreDaoDbTableColumn;
import br.com.mind5.business.materialStoreSearch.dao.MatorarchDaoDbTableColumn;
import br.com.mind5.business.materialStoreSnapshot.dao.MatorapDaoDbTableColumn;
import br.com.mind5.business.materialText.dao.MatextDaoDbTableColumn;
import br.com.mind5.business.materialTextDefault.dao.MatextaultDaoDbTableColumn;
import br.com.mind5.business.materialTextSearch.dao.MatextarchDaoDbTableColumn;
import br.com.mind5.business.materialTextSnapshot.dao.MatextsnapDaoDbTableColumn;
import br.com.mind5.business.notes.dao.NotesDaoDbTableColumn;
import br.com.mind5.business.order.dao.OrderDaoDbTableColumn;
import br.com.mind5.business.orderItem.dao.OrderemDaoDbTableColumn;
import br.com.mind5.business.orderItemList.dao.OrdemistDaoDbTableColumn;
import br.com.mind5.business.orderItemSearch.dao.OrdemarchDaoDbTableColumn;
import br.com.mind5.business.orderItemSnapshot.dao.OrdemrapDaoDbTableColumn;
import br.com.mind5.business.orderList.dao.OrdistDaoDbTableColumn;
import br.com.mind5.business.orderReserve.dao.OrderveDaoDbTableColumn;
import br.com.mind5.business.orderSearch.dao.OrdarchDaoDbTableColumn;
import br.com.mind5.business.orderSnapshot.dao.OrdnapDaoDbTableColumn;
import br.com.mind5.business.owner.dao.OwnerDaoDbTableColumn;
import br.com.mind5.business.ownerList.dao.OwnelisDaoDbTableColumn;
import br.com.mind5.business.ownerSearch.dao.OwnarchDaoDbTableColumn;
import br.com.mind5.business.ownerSnapshot.dao.OwnerapDaoDbTableColumn;
import br.com.mind5.business.person.dao.PersonDaoDbTableColumn;
import br.com.mind5.business.personBio.dao.PerbioDaoDbTableColumn;
import br.com.mind5.business.personBioSearch.dao.PerbiorchDaoDbTableColumn;
import br.com.mind5.business.personBioSnapshot.dao.PerbionapDaoDbTableColumn;
import br.com.mind5.business.personList.dao.PersolisDaoDbTableColumn;
import br.com.mind5.business.personSearch.dao.PerarchDaoDbTableColumn;
import br.com.mind5.business.personSnapshot.dao.PersonapDaoDbTableColumn;
import br.com.mind5.business.pet.dao.PetDaoDbTableColumn;
import br.com.mind5.business.petDefault.dao.PetaultDaoDbTableColumn;
import br.com.mind5.business.petSearch.dao.PetarchDaoDbTableColumn;
import br.com.mind5.business.petSnapshot.dao.PetsnapDaoDbTableColumn;
import br.com.mind5.business.phone.dao.PhoneDaoDbTableColumn;
import br.com.mind5.business.phoneDefault.dao.PhonaultDaoDbTableColumn;
import br.com.mind5.business.phoneSearch.dao.PhonarchDaoDbTableColumn;
import br.com.mind5.business.phoneSnapshot.dao.PhonapDaoDbTableColumn;
import br.com.mind5.business.phoneSnapshotSearch.dao.PhonaparchDaoDbTableColumn;
import br.com.mind5.business.planingData.dao.PlanataDaoDbTableColumn;
import br.com.mind5.business.refundPolicyOwner.dao.RefupownDaoDbTableColumn;
import br.com.mind5.business.refundPolicyStore.dao.RefuporeDaoDbTableColumn;
import br.com.mind5.business.refundPolicyStoreSearch.dao.RefuporarchDaoDbTableColumn;
import br.com.mind5.business.scheduleDayData.dao.SchedaytaDaoDbTableColumn;
import br.com.mind5.business.scheduleLine.dao.SchedineDaoDbTableColumn;
import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDaoDbTableColumn;
import br.com.mind5.business.scheduleList.dao.SchedistDaoDbTableColumn;
import br.com.mind5.business.scheduleMonthData.dao.SchedonthatDaoDbTableColumn;
import br.com.mind5.business.scheduleMoviment.dao.SchedovmDaoDbTableColumn;
import br.com.mind5.business.scheduleRange.dao.SchedageDaoDbTableColumn;
import br.com.mind5.business.scheduleReserve.dao.SchederveDaoDbTableColumn;
import br.com.mind5.business.scheduleSearch.dao.SchedarchDaoDbTableColumn;
import br.com.mind5.business.scheduleWeekData.dao.SchedeekdatDaoDbTableColumn;
import br.com.mind5.business.scheduleYearData.dao.SchedyeratDaoDbTableColumn;
import br.com.mind5.business.store.dao.StoreDaoDbTableColumn;
import br.com.mind5.business.storeFavorite.dao.StoriteDaoDbTableColumn;
import br.com.mind5.business.storeFavoriteSearch.dao.StoritarchDaoDbTableColumn;
import br.com.mind5.business.storeLeaveDate.dao.StolateDaoDbTableColumn;
import br.com.mind5.business.storeLeaveDateRange.dao.StolargDaoDbTableColumn;
import br.com.mind5.business.storeLeaveDateSearch.dao.StolarchDaoDbTableColumn;
import br.com.mind5.business.storeList.dao.StolisDaoDbTableColumn;
import br.com.mind5.business.storeLunchTime.dao.StuntmDaoDbTableColumn;
import br.com.mind5.business.storeLunchTimeSearch.dao.StuntmarchDaoDbTableColumn;
import br.com.mind5.business.storeLunchTimeSnapshot.dao.StuntmapDaoDbTableColumn;
import br.com.mind5.business.storeManager.dao.StomanDaoDbTableColumn;
import br.com.mind5.business.storeNearby.dao.StorbyDaoDbTableColumn;
import br.com.mind5.business.storeProspect.dao.StoprosDaoDbTableColumn;
import br.com.mind5.business.storeProspectSearch.dao.StoprarchDaoDbTableColumn;
import br.com.mind5.business.storeSearch.dao.SotarchDaoDbTableColumn;
import br.com.mind5.business.storeSnapshot.dao.StorapDaoDbTableColumn;
import br.com.mind5.business.storeText.dao.StorextDaoDbTableColumn;
import br.com.mind5.business.storeTextDefault.dao.StorextaultDaoDbTableColumn;
import br.com.mind5.business.storeTextSearch.dao.StorextarchDaoDbTableColumn;
import br.com.mind5.business.storeTextSnapshot.dao.StorextsnapDaoDbTableColumn;
import br.com.mind5.business.storeWorkTime.dao.StowotmDaoDbTableColumn;
import br.com.mind5.business.storeWorkTimeRange.dao.StoworgDaoDbTableColumn;
import br.com.mind5.business.storeWorkTimeSearch.dao.StowotarchDaoDbTableColumn;
import br.com.mind5.business.storeWorkTimeSnapshot.dao.StowotmapDaoDbTableColumn;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.config.sysDistrictSearch.dao.DaoSysdistrDbTableColumn;
import br.com.mind5.config.sysOwnerConfig.dao.DaoSysonfigDbTableColumn;
import br.com.mind5.config.sysOwnerSignup.dao.DaoSysonupDbTableColumn;
import br.com.mind5.config.sysStoreBusinessContent.dao.DaoSytorbcDbTableColumn;
import br.com.mind5.config.sysStorePartitioning.dao.DaoSytotinDbTableColumn;
import br.com.mind5.config.sysStoreSignup.dao.DaoSysotupDbTableColumn;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumn;
import br.com.mind5.discount.discountCouponItem.dao.DaoDisoupemDbTableColumn;
import br.com.mind5.discount.discountStore.dao.DaoDisoreDbTableColumn;
import br.com.mind5.discount.discountStoreSearch.dao.DaoDisorarchDbTableColumn;
import br.com.mind5.discount.discountStoreSnapshot.dao.DaoDisorapDbTableColumn;
import br.com.mind5.file.fileImage.dao.FimgDaoDbTableColumn;
import br.com.mind5.file.fileImageList.dao.FimistDaoDbTableColumn;
import br.com.mind5.file.fileImageSearch.dao.FimarchDaoDbTableColumn;
import br.com.mind5.file.fileImageSnapshot.dao.FimgnapDaoDbTableColumn;
import br.com.mind5.file.filePath.dao.FathDaoDbTableColumn;
import br.com.mind5.file.sysFileImage.dao.FimgysDaoDbTableColumn;
import br.com.mind5.file.sysFileImageSearch.dao.FimgysarchDaoDbTableColumn;
import br.com.mind5.file.sysFileImageSnapshot.dao.FimgysapDaoDbTableColumn;
import br.com.mind5.form.formAddress.dao.DaoFormessDbTableColumn;
import br.com.mind5.form.formPhone.dao.DaoFormoneDbTableColumn;
import br.com.mind5.masterData.areaPhone.dao.AreaneDaoDbTableColumn;
import br.com.mind5.masterData.areaPhoneSearch.dao.AreanarchDaoDbTableColumn;
import br.com.mind5.masterData.authorizationGroup.dao.AuthgroupDaoDbTableColumn;
import br.com.mind5.masterData.authorizationGroupRole.dao.AuthgroleDaoDbTableColumn;
import br.com.mind5.masterData.businessArea.dao.BusareaDaoDaoDbTableColumn;
import br.com.mind5.masterData.businessAreaSearch.dao.BusarearchDaoDbTableColumn;
import br.com.mind5.masterData.cartItemCategory.dao.CaritegDaoDbTableColumn;
import br.com.mind5.masterData.cartItemCategorySearch.dao.CaritegarchDaoDbTableColumn;
import br.com.mind5.masterData.country.dao.CountryDaoDbTableColumn;
import br.com.mind5.masterData.countryLegal.dao.CountralDaoDbTableColumn;
import br.com.mind5.masterData.countryLegalSearch.dao.CountrarchDaoDbTableColumn;
import br.com.mind5.masterData.countryPhone.dao.CountroneDaoDbTableColumn;
import br.com.mind5.masterData.countryPhoneSearch.dao.CountronarchDaoDbTableColumn;
import br.com.mind5.masterData.countrySearch.dao.CountarchDaoDbTableColumn;
import br.com.mind5.masterData.currency.dao.CurrencyDaoDbTableColumn;
import br.com.mind5.masterData.currencySearch.dao.CurrarshDaoDbTableColumn;
import br.com.mind5.masterData.dayParting.dao.DaypartDaoDbTableColumn;
import br.com.mind5.masterData.dayPartingSearch.dao.DayparchDaoDbTableColumn;
import br.com.mind5.masterData.discountStrategy.dao.DisegyDaoDbTableColumn;
import br.com.mind5.masterData.entityCategory.dao.EntitegDaoDbTableColumn;
import br.com.mind5.masterData.feeCategory.dao.FeecatDaoDbTableColumn;
import br.com.mind5.masterData.feeCategorySearch.dao.FeecatarchDaoDbTableColumn;
import br.com.mind5.masterData.fileDocType.dao.FidoceDaoDbTableColumn;
import br.com.mind5.masterData.fileDocTypeSearch.dao.FidocarchDaoDbTableColumn;
import br.com.mind5.masterData.gender.dao.GenderDaoDbTableColumn;
import br.com.mind5.masterData.genderSearch.dao.GendarchDaoDbTableColumn;
import br.com.mind5.masterData.language.dao.LanguDaoDbTableColumn;
import br.com.mind5.masterData.languageSearch.dao.LangarchDaoDbTableColumn;
import br.com.mind5.masterData.materialCategory.dao.MategDaoDbTableColumn;
import br.com.mind5.masterData.materialCategorySearch.dao.MategarchDaoDbTableColumn;
import br.com.mind5.masterData.materialGroup.dao.MatoupDaoDbTableColumn;
import br.com.mind5.masterData.materialGroupSearch.dao.MatouparchDaoDbTableColumn;
import br.com.mind5.masterData.materialSubgroup.dao.MatubupDaoDbTableColumn;
import br.com.mind5.masterData.materialSubgroupSearch.dao.DaoMatubuparchDbTableColumn;
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
import br.com.mind5.masterData.petType.dao.DaoPetypeDbTableColumn;
import br.com.mind5.masterData.petTypeSearch.dao.DaoPetyparchDbTableColumn;
import br.com.mind5.masterData.petWeight.dao.DaoPeteightDbTableColumn;
import br.com.mind5.masterData.petWeightSearch.dao.DaoPeteightarchDbTableColumn;
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
import br.com.mind5.payment.countryPartner.dao.CounparDaoDbTableColumn;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchDaoDbTableColumn;
import br.com.mind5.payment.creditCard.dao.CrecardDaoDbTableColumn;
import br.com.mind5.payment.creditCardSearch.dao.CrecarchDaoDbTableColumn;
import br.com.mind5.payment.customerPartner.dao.CusparDaoDbTableColumn;
import br.com.mind5.payment.customerPartnerSearch.dao.CusparchDaoDbTableColumn;
import br.com.mind5.payment.ownerPartner.dao.OwnparDaoDbTableColumn;
import br.com.mind5.payment.payOrder.dao.PayordDaoDbTableColumn;
import br.com.mind5.payment.payOrderItem.dao.PayordemDaoDbTableColumn;
import br.com.mind5.payment.payOrderItemList.dao.PayordemistDaoDbTableColumn;
import br.com.mind5.payment.payOrderItemSearch.dao.PayormarchDaoDbTableColumn;
import br.com.mind5.payment.payOrderList.dao.PayordistDaoDbTableColumn;
import br.com.mind5.payment.payOrderSearch.dao.PayordarchDaoDbTableColumn;
import br.com.mind5.payment.setupPartner.dao.SetuparDaoDbTableColumn;
import br.com.mind5.payment.storePartner.dao.StoparDaoDbTableColumn;
import br.com.mind5.payment.storePartnerList.dao.StoplisDaoDbTableColumn;
import br.com.mind5.payment.storePartnerSearch.dao.StoparchDaoDbTableColumn;
import br.com.mind5.payment.storePartnerSnapshot.dao.StoparnapDaoDbTableColumn;
import br.com.mind5.payment.systemPartner.dao.SysparDaoDbTableColumn;
import br.com.mind5.payment.systemPartnerSearch.dao.SysparchDaoDbTableColumn;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipDaoDbTableColumn;
import br.com.mind5.security.otpProspectStore.dao.OtporeDaoDbTableColumn;
import br.com.mind5.security.otpUserPassword.dao.OtperasDaoDbTableColumn;
import br.com.mind5.security.user.dao.UserDaoDbTableColumn;
import br.com.mind5.security.userList.dao.UselisDaoDbTableColumn;
import br.com.mind5.security.userPassword.dao.UpswdDaoDbTableColumn;
import br.com.mind5.security.userPasswordSearch.dao.UpswdarchDaoDbTableColumn;
import br.com.mind5.security.userSearch.dao.UserarchDaoDbTableColumn;
import br.com.mind5.security.userSnapshot.dao.UserapDaoDbTableColumn;
import br.com.mind5.security.username.dao.UsernameDaoDbTableColumn;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao.CutefilonagrDaoDbTableColumn;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.dao.CutefiloniveDaoDbTableColumn;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao.CustamonagrDaoDbTableColumn;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.dao.CustamoniveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.dao.SowordagrDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.dao.SowordiveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.dao.SowordarchDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao.SowalagrDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.dao.SowaliveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao.SowedulagrDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.dao.SoweduliveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao.SowedularchDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao.SowotagrDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.dao.SowotiveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.dao.SowotarchDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao.SowusagrDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.dao.SowusiveDaoDbTableColumn;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.dao.SowusarchDaoDbTableColumn;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao.StordagrDaoDbTableColumn;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.dao.StordiveDaoDbTableColumn;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao.StoronagrDaoDbTableColumn;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.dao.StoroniveDaoDbTableColumn;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao.StefilonagrDaoDbTableColumn;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.dao.StefiloniveDaoDbTableColumn;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao.SteddagrDaoDbTableColumn;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.dao.SteddiveDaoDbTableColumn;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao.StedmonagrDaoDbTableColumn;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.dao.StedmoniveDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.dao.StusorygrDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.dao.StusorygrarchDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.dao.StusoryliDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.dao.StusorylirchDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.dao.StusorygeDaoDbTableColumn;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.dao.StusorygerchDaoDbTableColumn;
import br.com.mind5.stats.statsUserStore.userStoreAggr.dao.DaoStusoraggDbTableColumn;
import br.com.mind5.stats.statsUserStore.userStoreLive.dao.DaoStusoreveDbTableColumn;
import br.com.mind5.stats.statsUserStore.userStoreStgn.dao.DaoStusorageDbTableColumn;
import br.com.mind5.webhook.moipMultipayment.dao.WokaymoipDaoDbTableColumn;
import br.com.mind5.webhook.moipRefund.dao.WokefumoipDaoDbTableColumn;

public final class DaoDbTableColumnAll {
	private static Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	static {
		tableColumns = new Hashtable<>();
		
		addTable(new MatDaoDbTableColumn());
		addTable(new MatextDaoDbTableColumn());
		addTable(new EmpmatDaoDbTableColumn());
		addTable(new MatsnapDaoDbTableColumn());
		addTable(new StoreDaoDbTableColumn());
		addTable(new StolisDaoDbTableColumn());
		addTable(new EmposDaoDbTableColumn());
		addTable(new CaritegDaoDbTableColumn());
		addTable(new StowotmDaoDbTableColumn());
		addTable(new StolateDaoDbTableColumn());
		addTable(new EmpwotmDaoDbTableColumn());
		addTable(new EmplateDaoDbTableColumn());
		addTable(new EmpwocoDaoDbTableColumn());
		addTable(new EmpwoutDaoDbTableColumn());
		addTable(new EmpDaoDbTableColumn());
		addTable(new EmpnapDaoDbTableColumn());
		addTable(new EmplisDaoDbTableColumn());
		addTable(new CusDaoDbTableColumn());
		addTable(new OwnerDaoDbTableColumn());
		addTable(new MatoreDaoDbTableColumn());
		addTable(new CartDaoDbTableColumn());
		addTable(new FeewnerDaoDbTableColumn());
		addTable(new FeedefDaoDbTableColumn());
		addTable(new CarterveDaoDbTableColumn());
		addTable(new OrderemDaoDbTableColumn());
		addTable(new OrderDaoDbTableColumn());
		addTable(new AddressDaoDbTableColumn());
		addTable(new AddresnapDaoDbTableColumn());
		addTable(new DaoFormessDbTableColumn());
		addTable(new PhoneDaoDbTableColumn());
		addTable(new PhonapDaoDbTableColumn());
		addTable(new DaoFormoneDbTableColumn());
		addTable(new PersonDaoDbTableColumn());
		addTable(new PersolisDaoDbTableColumn());
		addTable(new PersonapDaoDbTableColumn());
		addTable(new UserDaoDbTableColumn());
		addTable(new UserapDaoDbTableColumn());
		addTable(new StoparDaoDbTableColumn());
		addTable(new CounparDaoDbTableColumn());
		addTable(new CompDaoDbTableColumn());
		addTable(new UpswdDaoDbTableColumn());
		addTable(new UsernameDaoDbTableColumn());
		addTable(new MatmovDaoDbTableColumn());
		addTable(new MatockDaoDbTableColumn());
		addTable(new CusarchDaoDbTableColumn());
		addTable(new PlanataDaoDbTableColumn());
		addTable(new MatextsnapDaoDbTableColumn());
		addTable(new CartemDaoDbTableColumn());
		addTable(new OrderveDaoDbTableColumn());
		addTable(new DaoEmailDbTableColumn());
		addTable(new DaoEmabodyDbTableColumn());
		addTable(new OwnparDaoDbTableColumn());
		addTable(new StoparnapDaoDbTableColumn());
		addTable(new SetuparDaoDbTableColumn());
		addTable(new PayordDaoDbTableColumn());
		addTable(new CusparDaoDbTableColumn());
		addTable(new CrecardDaoDbTableColumn());
		addTable(new SysparchDaoDbTableColumn());
		addTable(new SysparDaoDbTableColumn());
		addTable(new PayordemDaoDbTableColumn());
		addTable(new PeresmoipDaoDbTableColumn());
		addTable(new WokaymoipDaoDbTableColumn());
		addTable(new WokefumoipDaoDbTableColumn());
		addTable(new SchedineDaoDbTableColumn());
		addTable(new StorapDaoDbTableColumn());
		addTable(new CompnapDaoDbTableColumn());
		addTable(new CusnapDaoDbTableColumn());
		addTable(new CuslisDaoDbTableColumn());
		addTable(new UselisDaoDbTableColumn());
		addTable(new SchedinapDaoDbTableColumn());
		addTable(new OrdarchDaoDbTableColumn());
		addTable(new OrdistDaoDbTableColumn());
		addTable(new SchedarchDaoDbTableColumn());
		addTable(new OrdnapDaoDbTableColumn());
		addTable(new OrdemrapDaoDbTableColumn());
		addTable(new PayordarchDaoDbTableColumn());
		addTable(new SchedistDaoDbTableColumn());
		addTable(new SchedovmDaoDbTableColumn());
		addTable(new SchedyeratDaoDbTableColumn());
		addTable(new SchedonthatDaoDbTableColumn());
		addTable(new SchedeekdatDaoDbTableColumn());
		addTable(new FimgDaoDbTableColumn());
		addTable(new FathDaoDbTableColumn());
		addTable(new DaoSymsgDbTableColumn());
		addTable(new OwnerapDaoDbTableColumn());
		addTable(new ComplisDaoDbTableColumn());
		addTable(new AddarchDaoDbTableColumn());
		addTable(new PhonarchDaoDbTableColumn());
		addTable(new SotarchDaoDbTableColumn());
		addTable(new ComparchDaoDbTableColumn());
		addTable(new PerarchDaoDbTableColumn());
		addTable(new FimarchDaoDbTableColumn());
		addTable(new FimistDaoDbTableColumn());
		addTable(new StorauthDaoDbTableColumn());
		addTable(new StolarchDaoDbTableColumn());
		addTable(new SchedageDaoDbTableColumn());
		addTable(new StoplisDaoDbTableColumn());
		addTable(new EmposarchDaoDbTableColumn());
		addTable(new StoworgDaoDbTableColumn());
		addTable(new StowotarchDaoDbTableColumn());
		addTable(new EmpwotarchDaoDbTableColumn());
		addTable(new EmplarchDaoDbTableColumn());
		addTable(new EmparchDaoDbTableColumn());
		addTable(new EmpmarchDaoDbTableColumn());
		addTable(new MatextarchDaoDbTableColumn());
		addTable(new MatextaultDaoDbTableColumn());
		addTable(new MatlisDaoDbTableColumn());
		addTable(new MatarchDaoDbTableColumn());
		addTable(new MatorarchDaoDbTableColumn());
		addTable(new MatorapDaoDbTableColumn());
		addTable(new MatocarchDaoDbTableColumn());
		addTable(new MatmarchDaoDbTableColumn());
		addTable(new UserarchDaoDbTableColumn());
		addTable(new StoparchDaoDbTableColumn());
		addTable(new CartemarchDaoDbTableColumn());
		addTable(new EmpworgDaoDbTableColumn());
		addTable(new EmplargDaoDbTableColumn());
		addTable(new StolargDaoDbTableColumn());
		addTable(new OrdemarchDaoDbTableColumn());
		addTable(new CompcoDaoDbTableColumn());
		addTable(new OwnelisDaoDbTableColumn());
		addTable(new CusparchDaoDbTableColumn());
		addTable(new CrecarchDaoDbTableColumn());
		addTable(new CounparchDaoDbTableColumn());
		addTable(new PayormarchDaoDbTableColumn());
		addTable(new PayordistDaoDbTableColumn());
		addTable(new PayordemistDaoDbTableColumn());
		addTable(new DaoMoonasarchDbTableColumn());
		addTable(new DaoMoonaseDbTableColumn());
		addTable(new MooncalDaoDbTableColumn());
		addTable(new CalateDaoDbTableColumn());
		addTable(new DaoStateDbTableColumn());
		addTable(new DaoStatarchDbTableColumn());
		addTable(new LanguDaoDbTableColumn());
		addTable(new LangarchDaoDbTableColumn());
		addTable(new CurrencyDaoDbTableColumn());
		addTable(new CurrarshDaoDbTableColumn());
		addTable(new DaoTimezoneDbTableColumn());
		addTable(new DaoTimezonarchDbTableColumn());
		addTable(new CountroneDaoDbTableColumn());
		addTable(new CountronarchDaoDbTableColumn());
		addTable(new AreaneDaoDbTableColumn());
		addTable(new AreanarchDaoDbTableColumn());
		addTable(new CountryDaoDbTableColumn());
		addTable(new CountarchDaoDbTableColumn());
		addTable(new AuthgroleDaoDbTableColumn());
		addTable(new MategDaoDbTableColumn());
		addTable(new MategarchDaoDbTableColumn());
		addTable(new DaoMatypeDbTableColumn());
		addTable(new DaoMatyparchDbTableColumn());
		addTable(new DaoMatunitDbTableColumn());
		addTable(new DaoMatunitarchDbTableColumn());
		addTable(new BusareaDaoDaoDbTableColumn());
		addTable(new BusarearchDaoDbTableColumn());
		addTable(new MatoupDaoDbTableColumn());
		addTable(new MatouparchDaoDbTableColumn());
		addTable(new GenderDaoDbTableColumn());
		addTable(new GendarchDaoDbTableColumn());
		addTable(new DaoWeekdayDbTableColumn());
		addTable(new DaoWeekdarchDbTableColumn());
		addTable(new DaypartDaoDbTableColumn());
		addTable(new DayparchDaoDbTableColumn());
		addTable(new DaoOrderatusDbTableColumn());
		addTable(new DaoOrderatarchDbTableColumn());
		addTable(new FeecatDaoDbTableColumn());
		addTable(new FeecatarchDaoDbTableColumn());
		addTable(new DaoRefupoDbTableColumn());
		addTable(new RefupownDaoDbTableColumn());
		addTable(new RefuporeDaoDbTableColumn());
		addTable(new DaoRefugroupDbTableColumn());
		addTable(new DaoRefugritemDbTableColumn());
		addTable(new DaoRefugritarchDbTableColumn());
		addTable(new DaoPaymenusDbTableColumn());
		addTable(new DaoPaymenusarchDbTableColumn());
		addTable(new OrdemistDaoDbTableColumn());
		addTable(new SchederveDaoDbTableColumn());
		addTable(new DaoRefugrarchDbTableColumn());
		addTable(new RefuporarchDaoDbTableColumn());
		addTable(new AuthgroupDaoDbTableColumn());
		addTable(new DaoPayparDbTableColumn());
		addTable(new DaoSysenvDbTableColumn());
		addTable(new DaoUseregDbTableColumn());
		addTable(new EntitegDaoDbTableColumn());
		addTable(new DaoPositionDbTableColumn());
		addTable(new DaoMamovypeDbTableColumn());
		addTable(new SchedaytaDaoDbTableColumn());
		addTable(new DaoSchedatusDbTableColumn());
		addTable(new DaoMonthDbTableColumn());
		addTable(new CalatarchDaoDbTableColumn());
		addTable(new DaoMontharchDbTableColumn());
		addTable(new CaleekyDaoDbTableColumn());
		addTable(new DaoSysonupDbTableColumn());
		addTable(new OwnarchDaoDbTableColumn());
		addTable(new FidoceDaoDbTableColumn());
		addTable(new FidocarchDaoDbTableColumn());
		addTable(new OtporeDaoDbTableColumn());
		addTable(new StoprosDaoDbTableColumn());
		addTable(new DaoProstusDbTableColumn());
		addTable(new DaoProstarchDbTableColumn());
		addTable(new StoprarchDaoDbTableColumn());
		addTable(new OtperasDaoDbTableColumn());
		addTable(new SchedauthDaoDbTableColumn());
		addTable(new StorbyDaoDbTableColumn());
		addTable(new NotesDaoDbTableColumn());
		addTable(new DaoSytotinDbTableColumn());
		addTable(new DaoSysonfigDbTableColumn());
		addTable(new UpswdarchDaoDbTableColumn());
		addTable(new MatubupDaoDbTableColumn());
		addTable(new DaoMatubuparchDbTableColumn());
		addTable(new AddaultDaoDbTableColumn());
		addTable(new PhonaultDaoDbTableColumn());
		addTable(new StoriteDaoDbTableColumn());
		addTable(new StoritarchDaoDbTableColumn());
		addTable(new StorextDaoDbTableColumn());
		addTable(new StorextaultDaoDbTableColumn());
		addTable(new StorextarchDaoDbTableColumn());
		addTable(new StorextsnapDaoDbTableColumn());
		addTable(new DaoSysotupDbTableColumn());
		addTable(new DaoSytorbcDbTableColumn());
		addTable(new CountralDaoDbTableColumn());
		addTable(new CountrarchDaoDbTableColumn());
		addTable(new CaritegarchDaoDbTableColumn());
		addTable(new FimgnapDaoDbTableColumn());
		addTable(new AddresnaparchDaoDbTableColumn());
		addTable(new PhonaparchDaoDbTableColumn());
		addTable(new DisegyDaoDbTableColumn());
		addTable(new DaoDisoreDbTableColumn());
		addTable(new DaoDisorarchDbTableColumn());
		addTable(new DaoDisoupemDbTableColumn());
		addTable(new DaoDisorapDbTableColumn());
		addTable(new DaoStusoreveDbTableColumn());
		addTable(new DaoStusorageDbTableColumn());
		addTable(new DaoStusoraggDbTableColumn());
		addTable(new DaoSysdistrDbTableColumn());
		addTable(new StusorygeDaoDbTableColumn());
		addTable(new StusoryliDaoDbTableColumn());
		addTable(new StusorygrDaoDbTableColumn());
		addTable(new StusorygerchDaoDbTableColumn());
		addTable(new StusorylirchDaoDbTableColumn());
		addTable(new StusorygrarchDaoDbTableColumn());
		addTable(new FimgysDaoDbTableColumn());
		addTable(new FimgysarchDaoDbTableColumn());
		addTable(new FimgysapDaoDbTableColumn());
		addTable(new DaoPetypeDbTableColumn());
		addTable(new DaoPetyparchDbTableColumn());
		addTable(new DaoPeteightDbTableColumn());
		addTable(new DaoPeteightarchDbTableColumn());
		addTable(new PetDaoDbTableColumn());
		addTable(new PetsnapDaoDbTableColumn());
		addTable(new PetarchDaoDbTableColumn());
		addTable(new PerbioDaoDbTableColumn());
		addTable(new PerbionapDaoDbTableColumn());
		addTable(new PerbiorchDaoDbTableColumn());
		addTable(new PetaultDaoDbTableColumn());
		addTable(new SowotiveDaoDbTableColumn());
		addTable(new CalonthDaoDbTableColumn());
		addTable(new CalontharchDaoDbTableColumn());
		addTable(new SowusiveDaoDbTableColumn());
		addTable(new SowordiveDaoDbTableColumn());
		addTable(new SoweduliveDaoDbTableColumn());
		addTable(new SowaliveDaoDbTableColumn());
		addTable(new SteddiveDaoDbTableColumn());
		addTable(new SteddagrDaoDbTableColumn());
		addTable(new StedmoniveDaoDbTableColumn());
		addTable(new StedmonagrDaoDbTableColumn());
		addTable(new StordiveDaoDbTableColumn());
		addTable(new StordagrDaoDbTableColumn());
		addTable(new StoroniveDaoDbTableColumn());
		addTable(new StoronagrDaoDbTableColumn());
		addTable(new SowordagrDaoDbTableColumn());
		addTable(new SowordarchDaoDbTableColumn());
		addTable(new SowedulagrDaoDbTableColumn());
		addTable(new SowedularchDaoDbTableColumn());
		addTable(new SowalagrDaoDbTableColumn());
		addTable(new SowotagrDaoDbTableColumn());
		addTable(new SowotarchDaoDbTableColumn());
		addTable(new SowusarchDaoDbTableColumn());
		addTable(new SowusagrDaoDbTableColumn());
		addTable(new StefiloniveDaoDbTableColumn());
		addTable(new StefilonagrDaoDbTableColumn());
		addTable(new CustamoniveDaoDbTableColumn());
		addTable(new CustamonagrDaoDbTableColumn());
		addTable(new CutefiloniveDaoDbTableColumn());
		addTable(new CutefilonagrDaoDbTableColumn());
		addTable(new StowotmapDaoDbTableColumn());
		addTable(new EmpwotmapDaoDbTableColumn());
		addTable(new StuntmapDaoDbTableColumn());
		addTable(new StuntmarchDaoDbTableColumn());
		addTable(new StowotmDaoDbTableColumn());
		addTable(new StuntmDaoDbTableColumn());
		addTable(new EmplutmapDaoDbTableColumn());
		addTable(new EmplutmarchDaoDbTableColumn());
		addTable(new EmpulranDaoDbTableColumn());
		addTable(new EmplutmDaoDbTableColumn());
		addTable(new StomanDaoDbTableColumn());
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
