FROM node:18-alpine AS builder
WORKDIR /app
COPY package.json ./
RUN yarn install
COPY . .
RUN yarn build

FROM nginx:1.23-alpine-slim
COPY --from=builder /app/build /usr/share/nginx/spb
RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
