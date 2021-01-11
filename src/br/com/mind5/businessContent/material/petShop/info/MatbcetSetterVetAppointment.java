package br.com.mind5.businessContent.material.petShop.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class MatbcetSetterVetAppointment extends InfoSetterTemplate<MatbcetInfo> {
	
	@Override protected MatbcetInfo setAttrHook(MatbcetInfo recordInfo) {
		recordInfo.codType = 2;
		recordInfo.codMatCateg = 2;
		recordInfo.priceUnit = 60;
		recordInfo.codUnit = "MIN";
		recordInfo.codGroup = 4;
		recordInfo.codSubgroup = 1;
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
		result.txtMat = "Consulta Veterinária";
		result.description = "Para filhotes, é recomendável que a consulta seja realizada mensalmente até os 6 meses de vida para mater as vacinas em dias, cuidar da castração e observar a dentição. Para adultos, o recomendável é ao menos uma vez por ano para os reforços das vacinas e vermuficação. Para idosos, o recomendável consultas a cada 6 meses para acompanhanmento e identificação precoce de problemas.";
		result.isDefault = false;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "PT";
		
		return result;
	}
	
	
	
	private MatextInfo getTextEn(MatbcetInfo recordInfo) {
		MatextInfo result = new MatextInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.txtMat = "Appointment with Vet ";
		result.description = "For puppies, it's recommended that consultation is carried out monthly until the age of 6 months to keep the vaccines in days, take care of castration and observe teeth growth. For adults, recommendation is at least once a year for vaccine boosters, and vermification. For elderly, it's recommended to consult every 6 months for follow-up and early identification of health problems.";
		result.isDefault = true;
		result.isDeleted = false;
		result.username = recordInfo.username;
		result.codLanguage = "EN";
		
		return result;
	}
}
