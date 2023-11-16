/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */
import React, { useEffect, useState } from "react";
import { Text, View, StyleSheet } from 'react-native';
import { Slider } from '@react-native-assets/slider'
import RTNDrawer from 'rtn-drawer/js/RTNDrawerNativeComponent';
import { hello } from 'rnjsisample';

const helloMessage = hello();


const App: () => JSX.Element = () => {
  const [angle, setAngle] = useState(0)
	
  function onChange(value: number) {
    setAngle(value);
  }

  return (
      <View style={styles.container}>
	    <RTNDrawer
	      angle={angle}
	      style={styles.drawer}
	    />
	    <Slider
		  value={0}          
		  minimumValue={0}   
		  maximumValue={360} 
		  step={1}
		  onValueChange={onChange}
		  style={styles.slider}
	    />
            <Text style={styles.text}>Text from JSI: {helloMessage}</Text>
      </View>

  );
};

const styles = StyleSheet.create({
  container: {
	display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
	marginTop: '32'
  },

  slider: {
    width: '80%',
    marginTop: '32'
  },

  drawer: {
    width: 200,
    height: 200
  },

  text: {
    marginTop: '32',
    color: 'white',
  }
});

export default App;