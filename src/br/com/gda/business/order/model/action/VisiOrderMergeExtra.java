package br.com.gda.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderFlag;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiOrderMergeExtra extends ActionMultiVisitorTemplate<OrderInfo> {
	private OrderInfo firstItem;
	private List<OrderInfo> extras;
	
	
	public VisiOrderMergeExtra() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<OrderInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildFirstItem(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildExtras(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildFirstItem(List<OrderInfo> infoRecords) {
		if (isItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initFirstItem();
		buildRecordFirstItem(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isItem(List<OrderInfo> infoRecords) {
		for (OrderInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != OrderFlag.ITEM.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initFirstItem() {
		firstItem = null;
	}
	
	
	
	private void buildRecordFirstItem(List<OrderInfo> infoRecords) {
		OrderInfo firstRow = infoRecords.get(0);
		firstItem = firstRow;
	}
	
	
	
	private boolean buildExtras(List<OrderInfo> infoRecords) {
		if (isExtra(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initExtras();
		buildListExtras(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isExtra(List<OrderInfo> infoRecords) {
		for (OrderInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != OrderFlag.EXTRA.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initExtras() {
		extras = new ArrayList<>();
	}
	
	
	
	private void buildListExtras(List<OrderInfo> infoRecords) {
		extras.addAll(infoRecords);
	}
	
	
	
	@Override protected List<OrderInfo> executeHook() {
		return mergeExtraItem();
	}
	
	
	
	private List<OrderInfo> mergeExtraItem() {
		checkList();
		return merge();
	}
	
	
	
	private void checkList() {
		if (extras == null || extras.isEmpty())
			throw new IllegalStateException("extras" + SystemMessage.ACTION_NOT_INIT);
		
		if (firstItem  == null)
			throw new IllegalStateException("firstItem" + SystemMessage.ACTION_NOT_INIT);
	}
	
	
	
	private List<OrderInfo> merge() {
		List<OrderInfo> results = new ArrayList<>();
		
		for (OrderInfo eachExtra : extras) {
			OrderInfo clonedExtra = makeClone(eachExtra);
			clonedExtra.codOrder = firstItem.codOrder;
			results.add(clonedExtra);
		}		
		
		return results;
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
