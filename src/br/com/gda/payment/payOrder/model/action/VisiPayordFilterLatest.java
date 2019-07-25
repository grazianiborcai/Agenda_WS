package br.com.gda.payment.payOrder.model.action;

import java.util.Comparator;
import br.com.gda.model.action.commom.ActionVisitorTemplateFirstRow;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class VisiPayordFilterLatest extends ActionVisitorTemplateFirstRow<PayordInfo> {
	
	@Override protected Comparator<PayordInfo> getComparatorHook() {
		return makeComparator();
	}
	
	
	
	//TODO: pode ocosionar overflow ?
	private Comparator<PayordInfo> makeComparator() {
		return new Comparator<PayordInfo>() {
			    public int compare(PayordInfo i1,PayordInfo i2)
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
