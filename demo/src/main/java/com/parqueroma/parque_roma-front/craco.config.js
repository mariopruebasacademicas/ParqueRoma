const path = require('path');

module.exports = {
  style: {
    postcss: {
      plugins: [
        require('tailwindcss'),
        require('autoprefixer'),
      ],
    },
  },
  // La configuración de webpack es necesaria para que craco encuentre las rutas
  webpack: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
    },
  },
};