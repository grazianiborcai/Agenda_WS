package br.com.mind5.businessContent.material.petShop.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatbcetSetterDogVaccineRabies extends InfoSetterTemplate<MatbcetInfo> {
	
	@Override protected MatbcetInfo setAttrHook(MatbcetInfo recordInfo) {
		recordInfo.codType = 2;
		recordInfo.codMatCateg = 2;
		recordInfo.priceUnit = 20;
		recordInfo.codUnit = "MIN";
		recordInfo.codGroup = 4;
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
		result.txtMat = "Vacina Antirrábica";
		result.description = "Combate a Raiva em cães e gatos. Primeira dose com 120 dias e demais reforços anualmente.";
		result.isDefault = false;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "PT";
		
		return result;
	}
	
	
	
	private MatextInfo getTextEn(MatbcetInfo recordInfo) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.txtMat = "Rabies Vaccine";
		result.description = "Rabies is 100% fatal to dogs and cats, with no treatment available. Prevention is key. First dose can be administered as early as 3 months of age and subsequent doses should be discussed with your vet.";
		result.isDefault = true;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "EN";
		
		return result;
	}
}
