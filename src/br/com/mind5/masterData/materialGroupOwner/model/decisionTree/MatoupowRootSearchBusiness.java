package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeOwnelis;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeMatoup;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckReadBusiness;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatoupowRootSearchBusiness extends DeciTreeTemplateRead<MatoupowInfo> {
	
	public MatoupowRootSearchBusiness(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoupowCheckReadBusiness(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoupowInfo> mergeOwnelis = new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiMergeOwnelis.class);
		ActionLazy<MatoupowInfo> mergeMatoup = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiMergeMatoup.class);
		
		mergeOwnelis.addPostAction(mergeMatoup);
		
		actions.add(mergeOwnelis);
		return actions;
	}
}
