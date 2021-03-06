package br.com.mind5.businessContent.material.petShop.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatbcetSetterCatHaircut extends InfoSetterTemplate<MatbcetInfo> {
	
	@Override protected MatbcetInfo setAttrHook(MatbcetInfo recordInfo) {
		recordInfo.codType = 2;
		recordInfo.codMatCateg = 2;
		recordInfo.priceUnit = 60;
		recordInfo.codUnit = "MIN";
		recordInfo.codGroup = 3;
		recordInfo.codSubgroup = 2;
		recordInfo.codBusiness = 3;
		recordInfo = setTexts(recordInfo);
		
		return recordInfo;
	}
	
	
	
	private MatbcetInfo setTexts(MatbcetInfo recordInfo) {
		MatextInfo textPt = getTextPt(recordInfo);
		MatextInfo textEn = getTextEn(recordInfo);
		
		recordInfo.matextes.add(textPt);
		recordInfo.matextes.add(textEn);
		
		return recordInfo;
	}
	
	
	
	private MatextInfo getTextPt(MatbcetInfo recordInfo) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.txtMat = "Tosa Felina";
		result.description = "Cuidamos da aparência do seu gato. Aparamos as unhas, pêlos e recompensamos o seu gato em uma sala de tratamento tranquila e silenciosa.";
		result.isDefault = false;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "PT";
		
		return result;
	}
	
	
	
	private MatextInfo getTextEn(MatbcetInfo recordInfo) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.txtMat = "Cat Haircut";
		result.description = "We take care of your cat appearance. We shave or give a haircut, trim nails, and reward your cat in a calm, silent grooming room.";
		result.isDefault = true;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "EN";
		
		return result;
	}
}
