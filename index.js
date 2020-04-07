/*

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => App);
*/

import {NativeModules} from "react-native";


var ToastExample = NativeModules.ToastExample;


const gertecCamV1 = {
  codeBarEan8: async function () {
    return await ToastExample.startCameraV1("EAN 8");
  }
}

export default gertecCamV1;