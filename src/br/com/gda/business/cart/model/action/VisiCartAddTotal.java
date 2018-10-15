package br.com.gda.business.cart.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartFlag;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiCartAddTotal extends ActionMultiVisitorTemplate<CartInfo> {
	private CartInfo total;
	private List<CartInfo> allItems;
	
	
	public VisiCartAddTotal() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<CartInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildTotal(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildAllItems(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildTotal(List<CartInfo> infoRecords) {
		if (isTotal(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initTotal();
		buildRecordTotal(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isTotal(List<CartInfo> infoRecords) {
		for (CartInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.TOTAL.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initTotal() {
		total = null;
	}
	
	
	
	private void buildRecordTotal(List<CartInfo> infoRecords) {
		CartInfo firstRow = infoRecords.get(0);
		total = firstRow;
	}
	
	
	
	private boolean buildAllItems(List<CartInfo> infoRecords) {
		if (isAllItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initAllItems();
		buildListAllItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isAllItem(List<CartInfo> infoRecords) {
		for (CartInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.ALL.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initAllItems() {
		allItems = new ArrayList<>();
	}
	
	
	
	private void buildListAllItems(List<CartInfo> infoRecords) {
		allItems.addAll(infoRecords);
	}
	
	
	
	@Override protected List<CartInfo> executeHook() {
		return addTotalToAllItems();
	}
	
	
	
	private List<CartInfo> addTotalToAllItems() {
		checkList();
		return add();
	}
	
	
	
	private void checkList() {
		if (allItems == null || allItems.isEmpty())
			throw new IllegalStateException("allItems" + SystemMessage.ACTION_NOT_INIT);
		
		if (total  == null)
			throw new IllegalStateException("total" + SystemMessage.ACTION_NOT_INIT);
	}
	
	
	
	private List<CartInfo> add() {
		List<CartInfo> results = new ArrayList<>();
		
		for (CartInfo eachItem : allItems) {
			CartInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}		
		
		CartInfo cloned = makeClone(total);
		results.add(cloned);
		
		return results;
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
