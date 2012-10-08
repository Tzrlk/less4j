package com.github.sommeri.less4j.core.ast;

import java.util.ArrayList;
import java.util.List;

import com.github.sommeri.less4j.core.parser.HiddenTokenAwareTree;
import com.github.sommeri.less4j.utils.ArraysUtils;

public class RuleSet extends ASTCssNode {

  private List<Selector> selectors = new ArrayList<Selector>();
  private RuleSetsBody body;

  public RuleSet(HiddenTokenAwareTree token) {
    super(token);
  }
  
  public List<Selector> getSelectors() {
   return selectors;
  }
  
  public RuleSetsBody getBody() {
    return body;
  }

  public boolean hasEmptyBody() {
    return body==null? true : body.isEmpty();
  }

  public void setBody(RuleSetsBody body) {
    this.body = body;
  }

  @Override
  public List<? extends ASTCssNode> getChilds() {
    List<ASTCssNode> result = ArraysUtils.asNonNullList((ASTCssNode)body);
    result.addAll(0, selectors);
    return result;
  }

  public ASTCssNodeType getType() {
    return ASTCssNodeType.RULE_SET;
  }

  public void addSelectors(List<Selector> selectors) {
    this.selectors.addAll(selectors);
  }

  public void replaceSelectors(List<Selector> result) {
    selectors = new ArrayList<Selector>();
    selectors.addAll(result);
  }

  @Override
  public RuleSet clone() {
    RuleSet result = (RuleSet) super.clone();
    result.body = body==null?null:body.clone();
    result.selectors = ArraysUtils.deeplyClonedList(selectors);
    result.configureParentToAllChilds();
    return result;
  }
}
