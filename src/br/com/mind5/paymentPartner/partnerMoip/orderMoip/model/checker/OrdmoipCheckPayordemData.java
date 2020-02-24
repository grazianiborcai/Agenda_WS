package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipCheckPayordemData extends ModelCheckerTemplateSimpleV2<OrdmoipInfo> {

	public OrdmoipCheckPayordemData(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdmoipInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.payordemData == null )	
			return super.FAILED;		
		
		
		if ( checkItem(recordInfo)  == false ||
			 checkFee(recordInfo) 	== false ||
			 checkMat(recordInfo)  	== false	  )			
			return super.FAILED;
		
		
		
		if ( recordInfo.payordemData.codStore <= 0 )	
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkItem(OrdmoipInfo recordInfo) {
		if ( recordInfo.payordemData.codMat <= 0		&&
			 recordInfo.payordemData.codFeeCateg == DefaultValue.character() )				
			return super.FAILED;
		
		if ( recordInfo.payordemData.quantity 	<= 0	||
			 recordInfo.payordemData.price 	  	<= 0	||
			 recordInfo.payordemData.codCurr 	== null		)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkFee(OrdmoipInfo recordInfo) {
		if (recordInfo.payordemData.codFeeCateg == DefaultValue.character())
			return super.SUCCESS;
		
		if (recordInfo.payordemData.txtFeeCateg == null)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkMat(OrdmoipInfo recordInfo) {
		if ( recordInfo.payordemData.codMat <= 0 )
			return super.SUCCESS;
		
		
		if ( recordInfo.payordemData.matlisData == null )	
			return super.FAILED;
		
		
		if ( recordInfo.payordemData.matlisData.txtMat 	 	== null || 
			 recordInfo.payordemData.matlisData.txtMatCateg == null 	)	
			return super.FAILED;
		
		
		if ( recordInfo.payordemData.codStore <= 0 )
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_MOIP_MANDATORY_FIELD_EMPTY;
	}
}
