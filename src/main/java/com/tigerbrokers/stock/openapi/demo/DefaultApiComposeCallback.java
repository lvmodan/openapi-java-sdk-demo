package com.tigerbrokers.stock.openapi.demo;

import com.alibaba.fastjson.JSONObject;
import com.tigerbrokers.stock.openapi.client.socket.ApiComposeCallback;
import com.tigerbrokers.stock.openapi.client.socket.WebSocketClient;
import com.tigerbrokers.stock.openapi.client.struct.SubscribedSymbol;

/**
 * Description:
 * Created by lijiawen on 2018/05/23.
 */
public class DefaultApiComposeCallback implements ApiComposeCallback {

  @Override
  public void orderStatusChange(JSONObject jsonObject) {
    StringBuilder builder = new StringBuilder();
    for (String key : jsonObject.keySet()) {
      builder.append(key).append("=").append(jsonObject.get(key)).append("|");
    }
    System.out.println("order change:" + builder);
  }

  @Override
  public void positionChange(JSONObject jsonObject) {
    StringBuilder builder = new StringBuilder();
    for (String key : jsonObject.keySet()) {
      builder.append(key).append("=").append(jsonObject.get(key)).append("|");
    }
    System.out.println("position change:" + builder);
  }

  @Override
  public void assetChange(JSONObject jsonObject) {
    StringBuilder builder = new StringBuilder();
    for (String key : jsonObject.keySet()) {
      builder.append(key).append("=").append(jsonObject.get(key)).append("|");
    }
    System.out.println("asset change:" + builder);
  }

  @Override
  public void quoteChange(JSONObject jsonObject) {
    System.out.println("quoteChange:" + jsonObject.toJSONString());
  }

  @Override
  public void optionChange(JSONObject jsonObject) {

  }

  @Override
  public void subscribeEnd(JSONObject jsonObject) {
    System.out.println("subscribe end:" + jsonObject.toJSONString());
  }

  @Override
  public void cancelSubscribeEnd(JSONObject jsonObject) {
    System.out.println("cancel subscribe end:" + jsonObject.toJSONString());
  }

  @Override
  public void getSubscribedSymbolEnd(SubscribedSymbol subscribedSymbol) {
    System.out.println(JSONObject.toJSONString(subscribedSymbol));
  }

  @Override
  public void client(WebSocketClient client) {
  }

  @Override
  public void error(String errorMsg) {
    System.out.println("receive error:" + errorMsg);
  }

  @Override
  public void error(int id, int errorCode, String errorMsg) {
    System.out.println("receive error id:" + id + ",errorCode:" + errorCode + ",errorMsg:" + errorMsg);
  }

  @Override
  public void connectionClosed() {
    System.out.println("connection closed.");
  }

  @Override
  public void connectAck() {
    System.out.println("connect ack.");
  }
}
