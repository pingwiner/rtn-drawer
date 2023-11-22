
import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';


export interface Spec extends TurboModule {
  helloWorld(): string;
}

export default TurboModuleRegistry.getEnforcing<Spec>('RNJSISampleModule');

