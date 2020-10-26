package br.com.mind5.businessContent.material.petShop.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatbcetSetterCatHydration extends InfoSetterTemplate<MatbcetInfo> {
	
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
		result.txtMat = "Hidrtação Felina";
		result.description = "Massageamos o pelo do seu gato com óleo de coco. Isto deixa o pelo do seu gato mais brilhante, ajuda a combater infecções e hidrata a pele seca.";
		result.isDefault = true;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "PT";
		
		return result;
	}
	
	
	
	private MatextInfo getTextEn(MatbcetInfo recordInfo) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.txtMat = "Cat Hair Hydration";
		result.description = "We massage your cat's fur with coconut oil. It makes your cat's coat shinier, will help fight infections and moisturize dry skin.";
		result.isDefault = false;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "EN";
		
		return result;
	}
}
