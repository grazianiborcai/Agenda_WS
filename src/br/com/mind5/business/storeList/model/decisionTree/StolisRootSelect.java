package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeAddress;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeComplis;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeFimeco;
import br.com.mind5.business.storeList.model.action.StolisVisiMergePhone;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeStorac;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeStorext;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class StolisRootSelect extends DeciTreeTemplateWrite<StolisInfo> {
	
	public StolisRootSelect(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolisInfo> buildCheckerHook(DeciTreeOption<StolisInfo> option) {
		List<ModelChecker<StolisInfo>> queue = new ArrayList<>();		
		ModelChecker<StolisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStd<StolisInfo>> actions = new ArrayList<>();

		ActionStd <StolisInfo> selectSimple = new StolisRootSelectSimple(option).toAction();
		ActionLazy<StolisInfo> mergeComplis = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergeComplis.class);
		ActionLazy<StolisInfo> mergeAddress = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergeAddress.class);
		ActionLazy<StolisInfo> mergePhone   = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergePhone.class);
		ActionLazy<StolisInfo> mergeFimeco  = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergeFimeco.class);
		ActionLazy<StolisInfo> mergeStorext = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergeStorext.class);
		ActionLazy<StolisInfo> mergeStorac  = new ActionLazyCommom<StolisInfo>(option, StolisVisiMergeStorac.class);
		
		selectSimple.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeFimeco);
		mergeFimeco.addPostAction(mergeStorext);
		mergeStorext.addPostAction(mergeStorac);
		
		actions.add(selectSimple);
		return actions;
	}
}
