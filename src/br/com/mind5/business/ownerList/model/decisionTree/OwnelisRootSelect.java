package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiMergeBusarea;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiMergeComplis;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiMergeFimist;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiMergeToSelect;
import br.com.mind5.business.ownerList.model.checker.OwnelisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OwnelisRootSelect extends DeciTreeTemplateRead<OwnelisInfo> {

	public OwnelisRootSelect(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnelisInfo> buildCheckerHook(DeciTreeOption<OwnelisInfo> option) {
		List<ModelChecker<OwnelisInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnelisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnelisCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStd<OwnelisInfo>> actions = new ArrayList<>();

		ActionStd<OwnelisInfo> select = new ActionStdCommom<OwnelisInfo>(option, OwnelisVisiMergeToSelect.class);
		ActionLazy<OwnelisInfo> mergeComplis = new ActionLazyCommom<OwnelisInfo>(option, OwnelisVisiMergeComplis.class);
		ActionLazy<OwnelisInfo> mergeBusarea = new ActionLazyCommom<OwnelisInfo>(option, OwnelisVisiMergeBusarea.class);
		ActionLazy<OwnelisInfo> mergeFimist = new ActionLazyCommom<OwnelisInfo>(option, OwnelisVisiMergeFimist.class);
		
		select.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeBusarea);
		mergeBusarea.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
	