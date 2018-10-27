import { AppRegistry } from 'react-native'
import { name as appName } from './app.json'

import lib from './lib/build/js/lib'
const { App } = lib.io.github.woxtu.overlord

AppRegistry.registerComponent(appName, () => App)
