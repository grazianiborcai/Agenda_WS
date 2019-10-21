package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.Comparator;

import br.com.mind5.model.action.commom.ActionVisitorTemplateFirstRow;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class VisiPayordarchFilterLatest extends ActionVisitorTemplateFirstRow<PayordarchInfo> {
	
	@Override protected Comparator<PayordarchInfo> getComparatorHook() {
		return makeComparator();
	}
	
	
	
	//TODO: pode ocosionar overflow ?
	private Comparator<PayordarchInfo> makeComparator() {
		return new Comparator<PayordarchInfo>() {
			    public int compare(PayordarchInfo i1,PayordarchInfo i2)
				    {
				       long result = i2.codPayOrder - i1.codPayOrder;		       
				       
				       if (result > Integer.MAX_VALUE && i2.codPayOrder > i1.codPayOrder) 
				    	   return Integer.MAX_VALUE;
				       
				       if (result > Integer.MAX_VALUE && i1.codPayOrder > i2.codPayOrder) 
				    	   return Integer.MIN_VALUE;
				    	
				    	return (int) result;
				    }
				};		
	}
}
