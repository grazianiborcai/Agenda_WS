package br.com.mind5.business.employeeLeaveDateRange.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.info.obsolete.InfoUniquifyHelper_;

final class EmplargCopyBookice extends InfoCopierTemplate<EmplargInfo, BookiceInfo>{
	
	public EmplargCopyBookice() {
		super(new InfoUniquifyHelper_<EmplargInfo>());
	}
	
	
	
	@Override protected EmplargInfo makeCopyHook(BookiceInfo source) {
		EmplargInfo result = new EmplargInfo();
			
		result.codOwner = source.codOwner;	
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.dateValidFrom = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());
		result.dateValidTo = LocalDate.of(source.date.getYear(), source.date.getMonth(), source.date.getDayOfMonth());		
		result.timeValidFrom = LocalTime.of(source.beginTime.getHour(), source.beginTime.getMinute());
		result.timeValidTo = LocalTime.of(source.endTime.getHour(), source.endTime.getMinute());
		result.validFrom = LocalDateTime.of(result.dateValidFrom, result.timeValidFrom);
		result.validTo = LocalDateTime.of(result.dateValidTo, result.timeValidTo);
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
