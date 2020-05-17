package br.com.mind5.security.username.info;


import java.util.List;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UsernameCopier {
	public static UsernameInfo copyFromRefupown(RefupownInfo source) {
		InfoCopier<UsernameInfo, RefupownInfo> copier = new UsernameCopyRefupown();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromRefupown(List<RefupownInfo> sources) {
		InfoCopier<UsernameInfo, RefupownInfo> copier = new UsernameCopyRefupown();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromPaytus(PaytusInfo source) {
		InfoCopier<UsernameInfo, PaytusInfo> copier = new UsernameCopyPaytus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromPaytus(List<PaytusInfo> sources) {
		InfoCopier<UsernameInfo, PaytusInfo> copier = new UsernameCopyPaytus();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromOrdist(OrdistInfo source) {
		InfoCopier<UsernameInfo, OrdistInfo> copier = new UsernameCopyOrdist();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromOrdist(List<OrdistInfo> sources) {
		InfoCopier<UsernameInfo, OrdistInfo> copier = new UsernameCopyOrdist();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromCarterco(CartercoInfo source) {
		InfoCopier<UsernameInfo, CartercoInfo> copier = new UsernameCopyCarterco();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromCarterco(List<CartercoInfo> sources) {
		InfoCopier<UsernameInfo, CartercoInfo> copier = new UsernameCopyCarterco();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromUpswd(UpswdInfo source) {
		InfoCopier<UsernameInfo, UpswdInfo> copier = new UsernameCopyUpswd();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromUpswd(List<UpswdInfo> sources) {
		InfoCopier<UsernameInfo, UpswdInfo> copier = new UsernameCopyUpswd();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static UsernameInfo copyFromFimg(FimgInfo source) {
		InfoCopier<UsernameInfo, FimgInfo> copier = new UsernameCopyFimg();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromFimg(List<FimgInfo> sources) {
		InfoCopier<UsernameInfo, FimgInfo> copier = new UsernameCopyFimg();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromRefu(RefuInfo source) {
		InfoCopier<UsernameInfo, RefuInfo> copier = new UsernameCopyRefu();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromRefu(List<RefuInfo> sources) {
		InfoCopier<UsernameInfo, RefuInfo> copier = new UsernameCopyRefu();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static UsernameInfo copyFromRefem(RefemInfo source) {
		InfoCopier<UsernameInfo, RefemInfo> copier = new UsernameCopyRefem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromRefem(List<RefemInfo> sources) {
		InfoCopier<UsernameInfo, RefemInfo> copier = new UsernameCopyRefem();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromTokemoip(TokemoipInfo source) {
		InfoCopier<UsernameInfo, TokemoipInfo> copier = new UsernameCopyTokemoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromTokemoip(List<TokemoipInfo> sources) {
		InfoCopier<UsernameInfo, TokemoipInfo> copier = new UsernameCopyTokemoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromAccemoip(AccemoipInfo source) {
		InfoCopier<UsernameInfo, AccemoipInfo> copier = new UsernameCopyAccemoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromAccemoip(List<AccemoipInfo> sources) {
		InfoCopier<UsernameInfo, AccemoipInfo> copier = new UsernameCopyAccemoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<UsernameInfo, CusparInfo> copier = new UsernameCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<UsernameInfo, CusparInfo> copier = new UsernameCopyCuspar();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static UsernameInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<UsernameInfo, CrecardInfo> copier = new UsernameCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<UsernameInfo, CrecardInfo> copier = new UsernameCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromPayord(PayordInfo source) {
		InfoCopier<UsernameInfo, PayordInfo> copier = new UsernameCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<UsernameInfo, PayordInfo> copier = new UsernameCopyPayord();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStore(StoreInfo source) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStowotm(StowotmInfo source) {
		InfoCopier<UsernameInfo, StowotmInfo> copier = new UsernameCopyStowotm();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStowotm(List<StowotmInfo> sources) {
		InfoCopier<UsernameInfo, StowotmInfo> copier = new UsernameCopyStowotm();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStolate(StolateInfo source) {
		InfoCopier<UsernameInfo, StolateInfo> copier = new UsernameCopyStolate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStolate(List<StolateInfo> sources) {
		InfoCopier<UsernameInfo, StolateInfo> copier = new UsernameCopyStolate();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMat(MatInfo source) {
		InfoCopier<UsernameInfo, MatInfo> copier = new UsernameCopyMat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMat(List<MatInfo> sources) {
		InfoCopier<UsernameInfo, MatInfo> copier = new UsernameCopyMat();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatmov(MatmovInfo source) {
		InfoCopier<UsernameInfo, MatmovInfo> copier = new UsernameCopyMatmov();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatmov(List<MatmovInfo> sources) {
		InfoCopier<UsernameInfo, MatmovInfo> copier = new UsernameCopyMatmov();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatore(MatoreInfo source) {
		InfoCopier<UsernameInfo, MatoreInfo> copier = new UsernameCopyMatore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatore(List<MatoreInfo> sources) {
		InfoCopier<UsernameInfo, MatoreInfo> copier = new UsernameCopyMatore();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromMatext(MatextInfo source) {
		InfoCopier<UsernameInfo, MatextInfo> copier = new UsernameCopyMatext();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromMatext(List<MatextInfo> sources) {
		InfoCopier<UsernameInfo, MatextInfo> copier = new UsernameCopyMatext();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmp(EmpInfo source) {
		InfoCopier<UsernameInfo, EmpInfo> copier = new UsernameCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<UsernameInfo, EmpInfo> copier = new UsernameCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmpos(EmposInfo source) {
		InfoCopier<UsernameInfo, EmposInfo> copier = new UsernameCopyEmpos();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmpos(List<EmposInfo> sources) {
		InfoCopier<UsernameInfo, EmposInfo> copier = new UsernameCopyEmpos();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmpwotm(EmpwotmInfo source) {
		InfoCopier<UsernameInfo, EmpwotmInfo> copier = new UsernameCopyEmpwotm();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmpwotm(List<EmpwotmInfo> sources) {
		InfoCopier<UsernameInfo, EmpwotmInfo> copier = new UsernameCopyEmpwotm();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmplate(EmplateInfo source) {
		InfoCopier<UsernameInfo, EmplateInfo> copier = new UsernameCopyEmplate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmplate(List<EmplateInfo> sources) {
		InfoCopier<UsernameInfo, EmplateInfo> copier = new UsernameCopyEmplate();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromEmpmat(EmpmatInfo source) {
		InfoCopier<UsernameInfo, EmpmatInfo> copier = new UsernameCopyEmpmat();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromEmpmat(List<EmpmatInfo> sources) {
		InfoCopier<UsernameInfo, EmpmatInfo> copier = new UsernameCopyEmpmat();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromCus(CusInfo source) {
		InfoCopier<UsernameInfo, CusInfo> copier = new UsernameCopyCus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromCus(List<CusInfo> sources) {
		InfoCopier<UsernameInfo, CusInfo> copier = new UsernameCopyCus();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UsernameInfo copyFromStopar(StoparInfo source) {
		InfoCopier<UsernameInfo, StoparInfo> copier = new UsernameCopyStopar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStopar(List<StoparInfo> sources) {
		InfoCopier<UsernameInfo, StoparInfo> copier = new UsernameCopyStopar();
		return copier.makeCopy(sources);
	}	
}
